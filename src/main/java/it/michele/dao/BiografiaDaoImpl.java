package it.michele.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import it.michele.beans.Contatto;
import it.michele.beans.Opere;
import it.michele.beans.Poesie;
import it.michele.beans.Premiazioni;
import it.michele.beans.Racconto;
import it.michele.services.BiografiaServiceImpl;

@Repository
public class BiografiaDaoImpl implements BiografiaDao{
    @Autowired
	DataSource dataSource = null;
    
    private static Logger logger = Logger.getLogger(BiografiaDaoImpl.class);
	private static Logger loggerMail = Logger.getLogger("sendMail");

    @Override
    public List<Premiazioni> getListaPremiazioni() throws Exception {
    	logger.info("BiografiaDaoImpl.getListaPremiazioni ");
    	
    	List<Premiazioni> premiazionis = new ArrayList<Premiazioni>();
		String query = "SELECT * FROM premiazioni p ORDER BY p.data";

    	Connection connection = DataSourceUtils.getConnection(dataSource);

    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    	    ResultSet rs = ps.executeQuery();

    	    while(rs.next()) {
    	    	Premiazioni premiazioni = new Premiazioni();
    	    	premiazioni.setId(rs.getInt("id"));
    	    	premiazioni.setTitolo(rs.getString("titolo"));
    	    	premiazioni.setData(rs.getString("data"));
    	    	premiazioni.setCitta(rs.getString("citta"));
    	    	premiazioni.setDescrizione (rs.getString("descrizione"));

				premiazionis.add(premiazioni);
    	    }

    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.getListaPremiazioni SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
		return premiazionis;
    }


	@Override
	public Premiazioni getPremiazioni(Integer id) throws Exception {
		logger.info("BiografiaDaoImpl.getPremiazioni "+id);
		Premiazioni premiazioni = null;

    	String query = "SELECT * FROM premiazioni c WHERE c.id = ?";
		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    	    if(rs.next()) {
    	    	premiazioni = new Premiazioni();
    	    	premiazioni.setId(rs.getInt("id"));
    	    	premiazioni.setTitolo(rs.getString("titolo"));
    	    	premiazioni.setData(rs.getString("data"));
    	    	premiazioni.setCitta(rs.getString("citta"));
    	    	premiazioni.setDescrizione(rs.getString("descrizione"));
    	    	
    	    }
    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.getListaPremiazioni SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}

		return premiazioni;
	}
	
	@Override
	public Opere getOpere(Integer id) throws Exception {
		logger.info("BiografiaDaoImpl.getOpere "+id);
		Opere opere = null;

    	String query = "SELECT * FROM opere c WHERE c.id = ?";
		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    	    if(rs.next()) {
    	    	opere = new Opere();
    	    	opere.setId(rs.getInt("id"));
    	    	opere.setData(rs.getInt("data"));
    	    	opere.setDescrizione(rs.getString("descrizione"));
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    logger.error("BiografiaDaoImpl.getListaPremiazioni SQLException -->> ", e);
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}

		return opere;
	}


	@Override
	public boolean insert(String titolo, String descrizione, String citta, int anno) throws Exception {
		logger.info("BiografiaDaoImpl.insert ");
    	String query = "INSERT INTO premiazioni (id, titolo, data, citta, descrizione) VALUES(?, ?, ?, ?, ?)";
    	
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	Boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
         
            ps.setInt(1, 0);
            ps.setString(2, titolo);
            ps.setInt(3, anno);
            ps.setString(4, citta);
            ps.setString(5, descrizione);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            ps.executeUpdate();
        	data=true;
    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.insert SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
  	
    	return data;
	}
	
	@Override
	public boolean insert(int anno, String descrizione) throws Exception {
		logger.info("BiografiaDaoImpl.insert opere");
    	String query = "INSERT INTO opere (id, data, descrizione) VALUES(?, ?, ?)";
    	
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	Boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
         
            ps.setInt(1, 0);
            ps.setInt(2, anno);
            ps.setString(3, descrizione);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            ps.executeUpdate();
        	data=true;
    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.insert opere SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
  	
    	return data;
	}


	@Override
	public boolean update(Integer id, String titolo, String descrizione, String citta, Integer anno) throws Exception {
		logger.info("BiografiaDaoImpl.update "+id);
		String query = "UPDATE premiazioni SET titolo = ?, data = ?, citta = ?, descrizione = ? WHERE id = ?";
		
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            
    		ps.setString(1, titolo);
            ps.setInt(2, anno);
            ps.setString(3, citta);
            ps.setString(4, descrizione);
            ps.setInt(5, id);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            ps.executeUpdate();
        	data=true;

    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.update  SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
	}

	@Override
	public boolean update(Integer id, Integer anno, String descrizione) throws Exception {
		logger.info("BiografiaDaoImpl.update "+id);
		String query = "UPDATE opere SET data = ?, descrizione = ? WHERE id = ?";
		
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, anno);
            ps.setString(2, descrizione);
            ps.setInt(3, id);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            ps.executeUpdate();
        	data=true;

    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.update  SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
	}


	@Override
	public boolean delete(Integer id) throws Exception {
		logger.info("BiografiaDaoImpl.delete "+id);
		boolean data = false;
		String query = "DELETE FROM premiazioni WHERE id = ?";

		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            data = true;
    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.delete  SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
	}
	
	@Override
	public boolean deleteOpere(Integer id) throws Exception {
		logger.info("BiografiaDaoImpl.deleteOpere "+id);
		boolean data = false;
		String query = "DELETE FROM opere WHERE id = ?";

		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            data = true;
    	} catch (SQLException e) {
    		logger.error("BiografiaDaoImpl.deleteOpere  SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
	}

}