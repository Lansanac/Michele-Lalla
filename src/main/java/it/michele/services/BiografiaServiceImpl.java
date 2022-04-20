package it.michele.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.michele.beans.Opere;
import it.michele.beans.Premiazioni;
import it.michele.dao.BiografiaDao;
import it.michele.services.exceptions.ServiceException;


@Service
public class BiografiaServiceImpl implements BiografiaService{
    @Autowired
	private BiografiaDao biografiaDao = null;
    
    private static Logger logger = Logger.getLogger(BiografiaServiceImpl.class);
	private static Logger loggerMail = Logger.getLogger("sendMail");

	@Override
	public List<Premiazioni> getListaPremiazioni() throws ServiceException    {
		logger.info("BiografiaServiceImpl.getListaPremiazioni ");
		List<Premiazioni> raccontis = new ArrayList<Premiazioni>();

		try {
			raccontis = biografiaDao.getListaPremiazioni();
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.getListaPremiazioni Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return raccontis;
    }



    @Override
	public Premiazioni getPremiazioni(Integer id) throws ServiceException   {
    	logger.info("BiografiaServiceImpl.getPremiazioni ");
    	Premiazioni premiazioni = new Premiazioni();
		try {
			premiazioni = biografiaDao.getPremiazioni(id);
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.getListaPremiazioni Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return premiazioni;
    }
    
    @Override
	public Opere getOpere(Integer id) throws ServiceException   {
    	logger.info("BiografiaServiceImpl.getOpere "+id);
    	Opere opere = new Opere();
		try {
			opere = biografiaDao.getOpere(id);
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.getOpere Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return opere;
    }

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public boolean insert(Premiazioni premiazioni) throws ServiceException    {
		logger.info("BiografiaServiceImpl.insert ");
		Boolean data = false;
		try {
			
			if(premiazioni.getTitolo()!= null && premiazioni.getDescrizione()!= null && premiazioni.getCitta()
					!= null && premiazioni.getData() != null) {
				Integer anno = Integer.parseUnsignedInt(premiazioni.getData());
				data = biografiaDao.insert(premiazioni.getTitolo(), premiazioni.getDescrizione(), premiazioni.getCitta(), anno);
			}else {
				Exception e = new Exception();
				logger.error("BiografiaServiceImpl.getOpere Exception -->> \n Tutti i campi devo essere valorisati --->> ", e);
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}
			System.out.println("Poesie inserita!");
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.insert Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
    }
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public boolean insertOpere(Opere opere) throws ServiceException    {
		logger.info("BiografiaServiceImpl.insertOpere ");
		Boolean data = false;
		try {
			if(opere.getData() != null && opere.getDescrizione()!= null ) {
				data = biografiaDao.insert(opere.getData(), opere.getDescrizione());
			}else {
				Exception e = new Exception();
				logger.error("BiografiaServiceImpl.insertOpere Exception -->> \n Tutti i campi devo essere valorisati --->> ", e);
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}
			System.out.println("L'oprea inserita!");
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.insertOpere Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
    }

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public boolean update(Premiazioni premiazioni) throws ServiceException {
		logger.info("BiografiaServiceImpl.update ");
		boolean data = false;
		try {
			if(premiazioni.getTitolo()!= null && premiazioni.getDescrizione()!= null && premiazioni.getCitta()
					!= null && premiazioni.getData() != null) {
				Integer anno = Integer.parseUnsignedInt(premiazioni.getData());
				data =  biografiaDao.update(premiazioni.getId() ,premiazioni.getTitolo(), premiazioni.getDescrizione(), premiazioni.getCitta(), anno);
				System.out.println("Poesia è stata modificata!     "+premiazioni.getId());
			}else {
				Exception e = new Exception();
				logger.error("BiografiaServiceImpl.update Exception -->> \n Tutti i campi devo essere valorisati --->> ", e);
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}	
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.update Exception -->> ", e);
        	throw new ServiceException(e);
        } 
		return data;
	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public boolean updateOpere(Opere opere) throws ServiceException {
		logger.info("BiografiaServiceImpl.updateOpere ");
		boolean data = false;
		try {
			if(opere.getData()!= null && opere.getDescrizione()!= null) {
				data =  biografiaDao.update(opere.getId(), opere.getData(), opere.getDescrizione());
				System.out.println("L'opera è stata modificata!     "+opere.getId());
			}else {
				Exception e = new Exception();
				logger.error("BiografiaServiceImpl.updateOpere Exception -->> \n Tutti i campi devo essere valorisati --->> ", e);
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}	
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.updateOpere Exception -->> ", e);
			loggerMail.error("BiografiaServiceImpl.updateOpere Exception -->> ", e);
        	throw new ServiceException(e);
        } 
		return data;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		logger.info("BiografiaServiceImpl.delete "+id);
		boolean data = false;
		try {
			
			data = biografiaDao.delete(id);
			System.out.println("La poesia è stato eliminato!");
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.delete Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
		
	}
	
	@Override
	public boolean deleteOpere(Integer id) throws ServiceException {
		logger.info("BiografiaServiceImpl.delete "+id);
		boolean data = false;
		try {
			data = biografiaDao.deleteOpere(id);
			System.out.println("Lìopera è stato eliminato!");
        } catch(Exception e) {
        	logger.error("BiografiaServiceImpl.delete Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
	}

}