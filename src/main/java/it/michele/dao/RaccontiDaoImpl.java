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
import it.michele.services.RaccontiServiceImpl;

@Repository
public class RaccontiDaoImpl implements RaccontiDao{
    @Autowired
	DataSource dataSource = null;
    private static Logger logger = Logger.getLogger(RaccontiDaoImpl.class);

    @Override
    public List<Racconto> getListaRacconti() throws Exception {
    	logger.info("RaccontiDaoImpl.getListaRacconti ");
    	List<Racconto> raccontis = new ArrayList<Racconto>();
		String query = "SELECT * FROM racconti r"
				+ " ORDER BY r.titolo";

    	Connection connection = DataSourceUtils.getConnection(dataSource);

    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    	    ResultSet rs = ps.executeQuery();

    	    while(rs.next()) {
    	    	Racconto racconti = new Racconto();
    	    	racconti.setId(rs.getInt("id"));
    	    	racconti.setTitolo(rs.getString("titolo"));
    	    	racconti.setDescrizione (rs.getString("descrizione"));
    	    	racconti.setAnnoPubblicazione(rs.getString("anno_pubblicazione"));

				raccontis.add(racconti);
    	    }

    	} catch (SQLException e) {
    		logger.error("RaccontiDaoImpl.getListaRacconti SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
		return raccontis;
    }

	@Override
	public Boolean insert(String titolo, String descrizione, int anno) throws Exception {
		logger.info("RaccontiDaoImpl.insert ");
		System.out.println("<<<<<	RaccontiDAO.insert	 >>>>>");
		String query = "INSERT INTO racconti (id, titolo, descrizione, 	anno_pubblicazione) VALUES(?, ?, ?, ?)";
	
    	Connection connection = DataSourceUtils.getConnection(dataSource);
    	Boolean data = false;
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
         
            ps.setInt(1, 0);
            ps.setString(2, titolo);
            ps.setString(3, descrizione);
            ps.setInt(4, anno);
            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
            ps.executeUpdate();
        	data=true;
            
    	} catch (SQLException e) {
    		logger.error("RaccontiDaoImpl.insert SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
	}


    @Override
	public Racconto getRacconto(Integer id) throws Exception {
    	logger.info("RaccontiDaoImpl.getRacconto ID: "+id);
    	Racconto racconto = null;
		String query = "SELECT * FROM racconti c WHERE c.id = ?";
		Connection connection = DataSourceUtils.getConnection(dataSource);
    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    	    if(rs.next()) {
    	    	racconto = new Racconto();
    	    	racconto.setId(rs.getInt("id"));
    	    	racconto.setTitolo(rs.getString("titolo"));
    	    	racconto.setDescrizione(rs.getString("descrizione"));
    	    	racconto.setAnnoPubblicazione(rs.getString("anno_pubblicazione"));
    	    }
    	} catch (SQLException e) {
    		logger.error("RaccontiDaoImpl.getRacconto SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
		return racconto;
    }



	 @Override
	 public boolean update(Integer id, String titolo, String descrizione, Integer anno) throws Exception    {
		 logger.info("RaccontiDaoImpl.update ID: "+id);
		 boolean data = false;
		String query = "UPDATE racconti SET titolo = ?, descrizione = ?, anno_pubblicazione = ? WHERE id = ?";
	
	    	Connection connection = DataSourceUtils.getConnection(dataSource);
	    	
	    	try {
	    		PreparedStatement ps = connection.prepareStatement(query);
	            
	            ps.setString(1, titolo);
	            ps.setString(2, descrizione);
	            ps.setInt(3, anno);
	            ps.setInt(4, id);
	            //ps.setDate(4, new Date(racconti.getAnnoPubblicazione()));
	            System.out.println("<<<<<	SQL	 >>>>> "+ ps);
	            ps.executeUpdate();
	        	data=true;
	
	    	} catch (SQLException e) {
	    		logger.error("RaccontiDaoImpl.updete SQLException -->> ", e);
	    	    e.printStackTrace();
	    	    throw e;
	    	} finally {
	    	    DataSourceUtils.releaseConnection(connection, dataSource);
	    	}
		return data;
    }

	@Override
    public boolean delete(Integer id) throws Exception {
		logger.info("RaccontiDaoImpl.delete ID: "+id);
		boolean data = false;
		String query = "DELETE FROM racconti WHERE id = ?";

		Connection connection = DataSourceUtils.getConnection(dataSource);

    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            data = true;
    	} catch (SQLException e) {
    		logger.error("RaccontiDaoImpl.delete SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
    	return data;
    }



	  
}