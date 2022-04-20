package it.michele.dao;

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

import it.michele.beans.Poesie;

@Repository
public class PoesieDaoImpl implements PoesieDao
{
    @Autowired
	private DataSource dataSource = null;
	private static Logger logger = Logger.getLogger(PoesieDaoImpl.class.getName());

    @Override
    public List<Poesie> getListaPoesie() throws Exception {
    	logger.info("PoesieDaoImpl.getListaPoesie ");
    	List<Poesie> contratti = new ArrayList<Poesie>();
		String query = "SELECT * FROM poesie p"
				+ " ORDER BY p.titolo";
		logger.info("PoesieDaoImpl.getListaPoesie SQL: "+query);
    	Connection connection = DataSourceUtils.getConnection(dataSource);

    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    	    ResultSet rs = ps.executeQuery();

    	    while(rs.next()) {
    	    	Poesie poesie = new Poesie();
    	    	poesie.setId(rs.getInt("id"));
    	    	poesie.setTitolo(rs.getString("titolo"));
    	    	poesie.setDescrizione(rs.getString("descrizione"));
    	    	poesie.setDataPubblicazione(rs.getString("data_pubblicazione"));
				contratti.add(poesie);
    	    }

    	} catch (SQLException e) {
    		logger.error("PoesieDaoImpl.getListaPoesie SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
		return contratti;
    }
  
    @Override
	public Poesie getPoesie(Integer id) throws Exception {
    	logger.info("PoesieDaoImpl.getPoesie ");
    	Poesie poesie = null;

    	String query = "SELECT * FROM poesie c WHERE c.id = ?";
		Connection connection = DataSourceUtils.getConnection(dataSource);
		logger.info("PoesieDaoImpl.getPoesie query:"+query);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    	    if(rs.next()) {
    	    	poesie = new Poesie();
    	    	poesie.setId(rs.getInt("id"));
    	    	poesie.setTitolo(rs.getString("titolo"));
    	    	poesie.setDescrizione(rs.getString("descrizione"));
    	    	poesie.setDataPubblicazione(rs.getString("data_pubblicazione"));
    	    }
    	} catch (SQLException e) {
    		logger.error("PoesieDaoImpl.getPoesie SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}

		return poesie;
    }


    @Override
	public boolean insert(String titolo, String descrizione, int anno) throws Exception {
    	logger.info("PoesieDaoImpl.insert ");
    	String query = "INSERT INTO poesie (id, titolo, descrizione, data_pubblicazione) VALUES(?, ?, ?, ?)";
    	
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
         
            ps.setInt(1, 0);
            ps.setString(2, titolo);
            ps.setString(3, descrizione);
            ps.setInt(4, anno);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            logger.info("PoesieDaoImpl.getPoesie query:"+ps);
            ps.executeUpdate();
        	data=true;
    	} catch (SQLException e) {
    		logger.error("PoesieDaoImpl.getPoesie SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
  	
    	return data;
    }

	@Override
	public boolean update(Integer id, String titolo, String descrizione, Integer anno) throws Exception   {
		logger.info("PoesieDaoImpl.update ");
		String query = "UPDATE poesie SET titolo = ?, descrizione = ?, data_pubblicazione = ? WHERE id = ?";
		
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, titolo);
            ps.setString(2, descrizione);
            ps.setInt(3, anno);
            ps.setInt(4, id);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            logger.info("PoesieDaoImpl.update query:"+ps);
            ps.executeUpdate();
        	data=true;

    	} catch (SQLException e) {
    		logger.error("PoesieDaoImpl.update SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
    }

	@Override
    public boolean delete(Integer id) throws Exception {
		logger.info("PoesieDaoImpl.delete ");
		boolean data = false;
		String query = "DELETE FROM poesie WHERE id = ?";

		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            logger.info("PoesieDaoImpl.delete query:"+ps);
            data = true;
    	} catch (SQLException e) {
    		logger.error("PoesieDaoImpl.update SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
    }

	
}