package it.michele.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.michele.beans.Opere;
import it.michele.beans.Poesie;
import it.michele.beans.Premiazioni;
import it.michele.beans.Racconto;
import it.michele.controllers.BiografiaController;
import it.michele.dao.BiografiaDao;
import it.michele.dao.OpereDao;
import it.michele.dao.PoesieDao;
import it.michele.dao.RaccontiDao;
import it.michele.services.exceptions.ServiceException;


@Component
public class OpereServiceImpl implements OpereService{
	
    private static Logger logger = Logger.getLogger(OpereServiceImpl.class);
	private static Logger loggerMail = Logger.getLogger("sendMail");
	
    @Autowired
	private OpereDao opereDao = null;

	@Override
	public List<Opere> getListaOpere() throws ServiceException    {
		logger.info("OpereServiceImpl.getListaOpere ");
		List<Opere> operes = new ArrayList<Opere>();

		try {
			operes = opereDao.getListaOpere();
        } catch(Exception e) {
        	logger.error("OpereServiceImpl.getListaOpere Exception -->> ", e);
			loggerMail.error("OpereServiceImpl.getListaOpere Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return operes;
    }

}