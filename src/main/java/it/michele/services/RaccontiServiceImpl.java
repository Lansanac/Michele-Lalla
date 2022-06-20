package it.michele.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.michele.beans.Racconto;
import it.michele.dao.RaccontiDao;
import it.michele.services.exceptions.ServiceException;


@Service
public class RaccontiServiceImpl implements RaccontiService{
    @Autowired
	private RaccontiDao raccontiDao = null;
    private static Logger logger = Logger.getLogger(RaccontiServiceImpl.class);

	@Override
	public List<Racconto> getListaRacconto() throws ServiceException    {
		logger.info("RaccontiServiceImpl.getListaRacconto ");
		List<Racconto> raccontis = null;

		try {
			raccontis = raccontiDao.getListaRacconti();
        } catch(Exception e) {
        	logger.error("RaccontiServiceImpl.getListaRacconto Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return raccontis;
    }

    @Override
	public Racconto getRacconto(Integer id) throws ServiceException {
    	logger.info("RaccontiServiceImpl.getRacconto ");
    	Racconto racconto = null;
		try {
			racconto = raccontiDao.getRacconto(id);
        } catch(Exception e) {
        	logger.error("RaccontiServiceImpl.getRacconto Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return racconto;
    }


	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public boolean update(Racconto racconto) throws ServiceException {
		logger.info("RaccontiServiceImpl.update ");
		boolean data = false;
		try {
			if(racconto.getTitolo()!= null && racconto.getDescrizione()!= null && racconto.getAnnoPubblicazione() !=null) {
				Integer anno = Integer.parseUnsignedInt(racconto.getAnnoPubblicazione());
				data = raccontiDao.update(racconto.getId() ,racconto.getTitolo(), racconto.getDescrizione(), anno);
				System.out.println("Racconto modificata!");
				logger.info("RaccontiServiceImpl.update Racconto modificata!");
			}else {
				Exception e = new Exception();
				logger.info("PublicazioneServiceImpl.insert -- Tutti i campi devo essere valorisati!");
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}	
        } catch(Exception e) {
        	logger.error("RaccontiServiceImpl.update Exception -->> ", e);
        	throw new ServiceException(e);
        } 
		return data;
	}

	@Override
	public Boolean insert(Racconto racconti) throws Exception {
		logger.info("RaccontiServiceImpl.insert "+racconti);
		System.out.println("<<<<<	RaccontiService.insert	 >>>>>  " +racconti);
		Boolean data = false;
		if(racconti.getTitolo()!= null && racconti.getDescrizione()!= null && racconti.getAnnoPubblicazione() !=null) {
			Integer anno = Integer.parseUnsignedInt(racconti.getAnnoPubblicazione());
			data = raccontiDao.insert(racconti.getTitolo(), racconti.getDescrizione(), anno);
			logger.info("RaccontiServiceImpl.insert Racconto inserita!");
        	
		}else {
			Exception e = new Exception();
			logger.error("RaccontiServiceImpl.insert Exception -->> Tutti i campi devo essere valorisati ", e);
			throw new ServiceException("Tutti i campi devo essere valorisati", e);
		}
		return data;
	}


	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public boolean delete(Integer id) throws ServiceException {
		logger.info("RaccontiServiceImpl.delete ");
		boolean data = false;
		try {
			
			data = raccontiDao.delete(id);
			logger.info("RaccontiServiceImpl.delete -->> Racconto eliminato!");
			System.out.println("Racconto eliminato!");
        } catch(Exception e) {
        	logger.error("RaccontiServiceImpl.delete Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
	}

}