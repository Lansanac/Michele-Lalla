package it.michele.dao;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import it.michele.beans.Pubblicazione;

@Repository
public class PublicazioneDaoImpl implements PublicazioeDao {
	@Autowired
	DataSource dataSource = null;
	private static Logger logger = Logger.getLogger(PublicazioneDaoImpl.class);
	private static Logger loggerMail = Logger.getLogger("sendMail");

	public List<String> getTitolo() throws Exception{
		logger.info("PublicazioneDaoImpl.getTitolo ");

		List<String> pubblicazioneDesc = new ArrayList<String>();
		String query = "SELECT titolo FROM pubblicazioni";

		Connection connection = DataSourceUtils.getConnection(dataSource);

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pubblicazione pubblicazione = new Pubblicazione();
				pubblicazione.setTitolo(rs.getString("titolo"));
				pubblicazioneDesc.add(pubblicazione.getTitolo());
			}
		}catch (SQLException e) {
			logger.error("PublicazioneDaoImpl.getTitolo -->>  SQLException -->> ", e);
			loggerMail.error("PublicazioneDaoImpl.getTitolo -->>  SQLException -->> ", e);
			e.printStackTrace();
			throw e;
		} finally {

			DataSourceUtils.releaseConnection(connection, dataSource);
		}
		return pubblicazioneDesc;
	}
	
	@Override
	public List<Pubblicazione> getListaPubblicazione() throws Exception {
		logger.info("PublicazioneDaoImpl.getListaPubblicazione ");

		/*InputStream inputStream = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();*/

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
				pubblicazione.setImage(rs.getString("image"));

				/*Blob blob = rs.getBlob("image");
				if (blob != null) {
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					inputStream = blob.getBinaryStream();
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					byte[] imageBytes = outputStream.toByteArray();
					outputStream.reset();
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					pubblicazione.setImage(base64Image);
				} else {
					pubblicazione.setImage(null);
				}*/

				pubblicaziones.add(pubblicazione);
			}

		} catch (SQLException e) {
			logger.error("PublicazioneDaoImpl.getListaPubblicazione -->>  SQLException -->> ", e);
			loggerMail.error("PublicazioneDaoImpl.getListaPubblicazione -->>  SQLException -->> ", e);
			e.printStackTrace();
			throw e;
		} finally {

			/*putStream.close();*/
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
//		InputStream img = new BufferedInputStream(new FileInputStream(image));
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, titolo);
			ps.setString(2, description);
			ps.setInt(3, dataPubblicazione);
			ps.setString(4, image);

			int result = ps.executeUpdate();
			if (result > 0)
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
		/*InputStream inputStream = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();*/

		String query = "SELECT * FROM pubblicazioni pub WHERE pub.id = ?";
		Connection connection = DataSourceUtils.getConnection(dataSource);
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			pubblicazione = new Pubblicazione();
			if (rs.next()) {
				pubblicazione.setId(rs.getInt("id"));
				pubblicazione.setTitolo(rs.getString("titolo"));
				pubblicazione.setDescription(rs.getString("descrizione"));
				pubblicazione.setDataPubblicazioneM(rs.getInt("data_pubblicazione"));
				pubblicazione.setImage(rs.getString("image"));

				/*Blob blob = rs.getBlob("image");
				if (blob != null) {
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					inputStream = blob.getBinaryStream();
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
					byte[] imageBytes = outputStream.toByteArray();
					outputStream.reset();
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					pubblicazione.setImage(base64Image);
				} else {
					pubblicazione.setImage(null);
				}*/

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
	public boolean update(int id, String titolo, String descrizione, int anno, String image) throws Exception {
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
			// ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
			System.out.println("<<<<<	SQL	 >>>>> " + ps);
			logger.info("PublicazioneDaoImpl.getPubblicazione -->>  " + ps);
			ps.executeUpdate();
			data = true;

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