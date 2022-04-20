package it.michele.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.michele.beans.Poesie;
import it.michele.dao.PoesieDao;
import it.michele.services.exceptions.ServiceException;


@Service
public class PoesieServiceImpl implements PoesieService
{
    @Autowired
	private PoesieDao poesieDao = null;
	private static Logger logger = Logger.getLogger(PoesieServiceImpl.class.getName());

	@Override
	public List<Poesie> getListaPoesie() throws ServiceException    {
		logger.info("PoesieServiceImpl.getListaPoesie ");
		List<Poesie> poesie = null;

		try {
			poesie = poesieDao.getListaPoesie();
        } catch(Exception e) {
			logger.error("PoesieServiceImpl.getListaPoesie Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return poesie;
    }

    @Override
	public Poesie getPoesie(Integer id) throws ServiceException   {
    	logger.info("PoesieServiceImpl.getPoesie ");
    	Poesie poesie = new Poesie();
		try {
			poesie = poesieDao.getPoesie(id);
        } catch(Exception e) {
        	logger.error("PoesieServiceImpl.getPoesie Exception -->> ", e);
        	throw new ServiceException(e);
        }

		return poesie;
    }

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Boolean insert(Poesie poesie) throws ServiceException    {
		logger.info("PoesieServiceImpl.insert ");
		Boolean data = false;
		try {
			
			if(poesie.getTitolo()!= null && poesie.getDescrizione()!= null && poesie.getDataPubblicazione() != null) {
				Integer anno = Integer.parseUnsignedInt(poesie.getDataPubblicazione());
				data = poesieDao.insert(poesie.getTitolo(), poesie.getDescrizione(), anno);
			}else {
				Exception e = new Exception();
				logger.error("PoesieServiceImpl.insert Exception -->> Tutti i campi devo essere valorisati ", e);
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}
			System.out.println("Poesie inserita!");
        } catch(Exception e) {
        	logger.error("PoesieServiceImpl.insert Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
    }

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public boolean update(Poesie poesie) throws ServiceException {
		logger.info("PoesieServiceImpl.update ");
		boolean data = false;
		try {
			if(poesie.getTitolo()!= null && poesie.getDescrizione()!= null && poesie.getDataPubblicazione() !=null) {
				Integer anno = Integer.parseUnsignedInt(poesie.getDataPubblicazione());
				data =  poesieDao.update(poesie.getId() ,poesie.getTitolo(), poesie.getDescrizione(), anno);
				System.out.println("Poesia è stata modificata!");
			}else {
				Exception e = new Exception();
				logger.error("PoesieServiceImpl.update Exception -->> Tutti i campi devo essere valorisati ", e);
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}	
        } catch(Exception e) {
        	logger.error("PoesieServiceImpl.update Exception -->> ", e);
        	throw new ServiceException(e);
        } 
		return data;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		logger.info("PoesieServiceImpl.delete ");
		boolean data = false;
		try {
			
			data = poesieDao.delete(id);
			System.out.println("La poesia è stato eliminato!");
        } catch(Exception e) {
        	logger.error("PoesieServiceImpl.delete Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
		
	}

//	@Override
//	@Transactional(rollbackFor = ServiceException.class)
//	public void delete(Integer id) throws ServiceException {
//
//		try {
//			List<Poesie> poesie = poesieDao.getListaPoesie();
//			if (!poesie.isEmpty()) {
//				for (Poesie c : poesie) {
//					if (c.getAnagrafica().getId() == id) {
//						contrattoDao.delete(c.getId());
//					}
//				}
//			}
//			
//			poesieDao.delete(id);
//			System.out.println("Anagrafica eliminata!");
//        } catch(Exception e) {
//        	throw new ServiceException(e);
//        }
//	}

}