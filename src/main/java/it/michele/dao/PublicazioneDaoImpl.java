package it.michele.dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import it.michele.beans.Pubblicazione;

@Repository
public class PublicazioneDaoImpl implements PublicazioeDao {
	@Autowired
	DataSource dataSource = null;
    private static Logger logger = Logger.getLogger(PublicazioneDaoImpl.class);
	private static Logger loggerMail = Logger.getLogger("sendMail");


	@Override
	public List<Pubblicazione> getListaPubblicazione() throws Exception {
		logger.info("PublicazioneDaoImpl.getListaPubblicazione ");

		List<Pubblicazione> pubblicaziones = new ArrayList<Pubblicazione>();
		String query = "SELECT * FROM pubblicazioni p" + " ORDER BY p.data_pubblicazione";

		Connection connection = DataSourceUtils.getConnection(dataSource);
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pubblicazione pubblicazione = new Pubblicazione();
				pubblicazione.setId(rs.getInt("id"));
				pubblicazione.setTitolo(rs.getString("titolo"));
				pubblicazione.setDescription(rs.getString("descrizione"));
				pubblicazione.setDataPubblicazioneM(rs.getInt("data_pubblicazione"));
				
				// Find the application directory
				//String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
				//ThemeResource resource = getClass().getResource("img/themeimage.png");
				//ResourceResolver.getPathToPortal(pageContext.getServletConfig())
				//ResourceResolver resourceResolver = rrf.getServiceResourceResolver(Map object);
			    //resourceResolver.getResource(path);
				//FileOutputStream file = new FileOutputStream(System.getProperty("..\\MicheleProject\\src\\main\\webapp\\application\\img\\MLImg\\pub"+pubblicazione.getId()+".jpg"));
				//String dir = System.getProperty("user.dir");
				
				
				
				File dir = new File("src\\main\\webapp\\application\\img\\MLImg");
				String helper = dir.getAbsolutePath();
				String path1 = helper.substring(0, helper.length() - dir.getCanonicalPath().length());//this line may need a try-catch block
				File targetFile=new File(path1, dir+"\\pub"+pubblicazione.getId()+".jpg");
				System.out.println("dir1: "+path1);
				System.out.println("dir2: "+targetFile.toString());
				
				
				Blob clob = rs.getBlob(5);
				byte[] byteArr = clob.getBytes(1,(int)clob.length());
				//String path ="C:\\Users\\LansanaCa\\eclipse-workspace\\workspace-hibernate\\MicheleProject\\MicheleProject\\src\\main\\webapp\\application\\img\\MLImg\\pub"+pubblicazione.getId()+".jpg";
				String path ="C:\\eclipse\\MicheleProject\\MicheleProject\\src\\main\\webapp\\application\\img\\MLImg\\pub"+pubblicazione.getId()+".jpg";

				//Resource rsrc = this.resource.getResourceResolver().getResource(path);
				logger.info("PublicazioneDaoImpl.getListaPubblicazione -->> "+path);
				System.out.println(""+path);
				FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
				fileOutputStream.write(byteArr);  
				int my = path.lastIndexOf("application");
				String myPath = path.substring(my, path.length());
			    System.out.println("Image retrieved successfully. "+myPath);
				logger.info("PublicazioneDaoImpl.getListaPubblicazione -->> "+myPath);

			     
			    pubblicazione.setImage("\\MicheleProject\\"+myPath);
				pubblicaziones.add(pubblicazione);
				fileOutputStream.close();
			}

		} catch (SQLException e) {
			logger.error("PublicazioneDaoImpl.getListaPubblicazione -->>  SQLException -->> ", e);
			loggerMail.error("PublicazioneDaoImpl.getListaPubblicazione -->>  SQLException -->> ", e);
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
		return pubblicaziones;
	}



	@Override
	public boolean insert(String titolo, String description, int dataPubblicazione, String image) throws Exception {
		logger.info("PublicazioneDaoImpl.insert -->> ");

		boolean data = false;
		String query = "INSERT INTO pubblicazioni(titolo, descrizione, data_pubblicazione, image) VALUES(?, ?, ?, ?)";

		Connection connection = DataSourceUtils.getConnection(dataSource);
		InputStream img =  new BufferedInputStream(new FileInputStream(image));
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, titolo);
			ps.setString(2, description);
			ps.setInt(3, dataPubblicazione);
			
			ps.setBlob(4, img);

			int result = ps.executeUpdate();
			if(result>0)
				data = true;
		} catch (SQLException e) {
			logger.info("PublicazioneDaoImpl.insert -->>  SQLException -->> ", e);
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
		return data;
	}



	@Override
	public Pubblicazione getPubblicazione(int id) throws Exception {
		logger.info("PublicazioneDaoImpl.getPubblicazione ");

		Pubblicazione pubblicazione = null;

    	String query = "SELECT * FROM pubblicazioni pub WHERE pub.id = ?";
		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    		pubblicazione = new Pubblicazione();
    	    if(rs.next()) {
    	    	pubblicazione.setId(rs.getInt("id"));
				pubblicazione.setTitolo(rs.getString("titolo"));
				pubblicazione.setDescription(rs.getString("descrizione"));
				pubblicazione.setDataPubblicazioneM(rs.getInt("data_pubblicazione"));
				
				Blob clob = rs.getBlob(5);
				byte[] byteArr = clob.getBytes(1,(int)clob.length());
				String path ="C:\\Users\\LansanaCa\\eclipse-workspace\\workspace-hibernate\\MicheleProject\\MicheleProject\\src\\main\\webapp\\application\\img\\MLImg\\pub"+pubblicazione.getId()+".jpg";
				System.out.println(""+path);
			    logger.info("PublicazioneDaoImpl.getPubblicazione -->>  "+path);

				FileOutputStream fileOutputStream = new FileOutputStream(path);
				fileOutputStream.write(byteArr);  
				int my = path.lastIndexOf("application");
				String myPath = path.substring(my, path.length());
			    System.out.println("Image retrieved successfully. "+myPath);
			    logger.info("PublicazioneDaoImpl.getPubblicazione -->>  "+myPath);
			    
			    pubblicazione.setImage("\\MicheleProject\\"+myPath);
			    //pubblicazione.setImage(myPath);
				fileOutputStream.close();
    	    }
    	} catch (SQLException e) {
			logger.info("PublicazioneDaoImpl.getPubblicazione -->>  SQLException -->> ", e);
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}

		return pubblicazione;
	}
	@Override
	public boolean update(int id, String titolo, String descrizione, int anno, String image) throws Exception   {
	    logger.info("PublicazioneDaoImpl.update ");
		String query = "UPDATE pubblicazioni SET titolo = ?, descrizione = ?, data_pubblicazione =?, image = ? WHERE id = ?";
		
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, titolo);
            ps.setString(2, descrizione);
            ps.setInt(3, anno);
            ps.setString(4, image);
            ps.setInt(5, id);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            logger.info("PublicazioneDaoImpl.getPubblicazione -->>  "+ps);
            ps.executeUpdate();
        	data=true;

    	} catch (SQLException e) {
    		logger.info("PublicazioneDaoImpl.update -->>  SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
    }

	@Override
    public boolean delete(int id) throws Exception {
		logger.info("PublicazioneDaoImpl.delete  ");
		boolean data = false;
		String query = "DELETE FROM pubblicazioni WHERE id = ?";

		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            data = true;
    	} catch (SQLException e) {
    		logger.info("PublicazioneDaoImpl.delete -->>  SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
    }

}