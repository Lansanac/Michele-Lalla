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
import it.michele.services.OpereServiceImpl;

@Repository
public class OpereDaoImpl implements OpereDao{
    @Autowired
	DataSource dataSource = null;
    private static Logger logger = Logger.getLogger(OpereDaoImpl.class);
	private static Logger loggerMail = Logger.getLogger("sendMail");

    @Override
    public List<Opere> getListaOpere() throws Exception {
    	logger.info("OpereDaoImpl.getListaOpere ");
    	List<Opere> operes = new ArrayList<Opere>();
		String query = "SELECT * FROM opere o"
				+ " ORDER BY o.data";

    	Connection connection = DataSourceUtils.getConnection(dataSource);

    	try {
    		PreparedStatement ps = connection.prepareStatement(query);
    	    ResultSet rs = ps.executeQuery();

    	    while(rs.next()) {
    	    	Opere opere = new Opere();
    	    	opere.setId(rs.getInt("id"));
    	    	opere.setData(rs.getInt("data"));
    	    	opere.setDescrizione (rs.getString("descrizione"));

    	    	operes.add(opere);
    	    }

    	} catch (SQLException e) {
    		logger.error("OpereServiceImpl.getListaOpere SQLException -->> ", e);
			loggerMail.error("OpereServiceImpl.getListaOpere SQLException -->> ", e);
    	    e.printStackTrace();
    	    throw e;
    	} finally {
    	    DataSourceUtils.releaseConnection(connection, dataSource);
    	}
		return operes;
    }


}