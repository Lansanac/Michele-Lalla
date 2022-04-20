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
import it.michele.beans.Poesie;
import it.michele.beans.Racconto;
import it.michele.services.ContattoServiceImpl;

@Repository
public class ContattoDaoImpl implements ContattoDao {
	@Autowired
	DataSource dataSource = null;
	private static Logger logger = Logger.getLogger(ContattoDaoImpl.class);


	@Override
	public List<Contatto> getListaContatto() throws Exception {
		logger.info("ContattoDaoImpl.getListaContatto ");

		List<Contatto> contattos = new ArrayList<Contatto>();
		String query = "SELECT * FROM contatti_email CE" + " ORDER BY CE.nome";

		Connection connection = DataSourceUtils.getConnection(dataSource);

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Contatto contatto = new Contatto();
				contatto.setId(rs.getInt("id"));
				contatto.setNome(rs.getString("nome"));
				contatto.setEmail(rs.getString("email"));
				contatto.setSoggetto(rs.getString("soggetto"));
				contatto.setMessaggio(rs.getString("messaggio"));

				contattos.add(contatto);
			}

		} catch (SQLException e) {
			logger.info("ContattoDaoImpl.getListaContatto SQLException -->> ", e);
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
		return contattos;
	}



	@Override
	public void insert(Contatto contatto) throws Exception {
		logger.info("ContattoDaoImpl.insert ");
		String query = "INSERT INTO contatti_email(nome, email, soggetto, messaggio, data) VALUES( ?, ?, ?, ?, ?)";

		Connection connection = DataSourceUtils.getConnection(dataSource);

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, contatto.getNome());
			ps.setString(2, contatto.getEmail());
			ps.setString(3, contatto.getSoggetto());
			ps.setString(4, contatto.getMessaggio());
			ps.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			// ps.setDate(5, new Date(poesie.getDataInizio().getTime()));

			ps.executeUpdate();

		} catch (SQLException e) {
			logger.info("ContattoDaoImpl.getListaContatto SQLException -->> ", e);

			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}

	}

}