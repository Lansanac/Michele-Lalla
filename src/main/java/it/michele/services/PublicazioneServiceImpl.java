package it.michele.services;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import it.michele.beans.Pubblicazione;
import it.michele.dao.PublicazioeDao;
import it.michele.services.exceptions.ServiceException;

//import com.didisoft.pgp.mail.PGPMailUtils;
@Service
public class PublicazioneServiceImpl implements PublicazioeService {

	@Autowired
	private PublicazioeDao publicazineDao = null;
	private static Logger logger = Logger.getLogger(PublicazioneServiceImpl.class);

	@Override
	public boolean insert(Pubblicazione publicazione) throws ServiceException {
		logger.info("PublicazioneServiceImpl.insert ");
		boolean data = false;
		try {
			
			if(publicazione.getTitolo()!= null && publicazione.getDescription()!= null && publicazione.getDataPubblicazioneM() > 0) {
				if(publicazione.getImage()!=null) {
					Blob imgBlob = new SerialBlob(Base64Utils.decode(publicazione.getImage().getBytes()));
					data = publicazineDao.insert(publicazione.getTitolo(), publicazione.getDescription(), publicazione.getDataPubblicazioneM(), imgBlob);
				}else {
					data = publicazineDao.insert(publicazione.getTitolo(), publicazione.getDescription(), publicazione.getDataPubblicazioneM(), null);
				}				
			}else {
				logger.info("PublicazioneServiceImpl.insert -- Tutti i campi devo essere valorisati!");
				throw new ServiceException("Tutti i campi devo essere valorisati");
			}
			System.out.println("Poesie inserita!");
			logger.info("PublicazioneServiceImpl.insert Poesie inserita!");
        } catch(Exception e) {        	
			logger.error("PublicazioneServiceImpl.insert Exception -->> ", e);
			throw new ServiceException(e);

        }
		return data;
		
		
	}

	@Override
	public List<Pubblicazione> getListPubblicazione() throws ServiceException {
		logger.info("PublicazioneServiceImpl.getListPubblicazione ");

		List<Pubblicazione> publPubblicaziones = new ArrayList<Pubblicazione>();
		try {
			publPubblicaziones = publicazineDao.getListaPubblicazione();
		} catch (Exception e) {
			logger.error("PublicazioneServiceImpl.getListPubblicazione Exception -->> ", e);
			e.printStackTrace();
		}
		return publPubblicaziones;
	}

	@Override
	public Pubblicazione getPublicazione(int id) throws ServiceException {
		logger.info("PublicazioneServiceImpl.getPublicazione ");
		Pubblicazione pubblicazione = new Pubblicazione();
		try {
			pubblicazione = publicazineDao.getPubblicazione(id);
		} catch (Exception e) {
			logger.error("PublicazioneServiceImpl.getPublicazione Exception -->> ", e);
			throw new ServiceException(e);
		}
		
		return pubblicazione;
	}

	@Override
	public boolean update(Pubblicazione pubblicazione) throws ServiceException {
		logger.info("PublicazioneServiceImpl.update ");
		boolean data = false;
		System.out.println("=======> " + pubblicazione);
		try {
			
			
			if(pubblicazione.getId()>0 && pubblicazione.getTitolo()!= null && pubblicazione.getDescription()!= null && pubblicazione.getDataPubblicazioneM() > 0) {
				if(pubblicazione.getImage()!=null) {
					Blob imgBlob = new SerialBlob(Base64Utils.decode(pubblicazione.getImage().getBytes()));
					data = publicazineDao.update(pubblicazione.getId(), pubblicazione.getTitolo(), pubblicazione.getDescription(), pubblicazione.getDataPubblicazioneM(), imgBlob);
				}else {
					data = publicazineDao.update(pubblicazione.getId(), pubblicazione.getTitolo(), pubblicazione.getDescription(), pubblicazione.getDataPubblicazioneM(), null);
				}
				System.out.println("La pubblicazione è stata modificata!");
				logger.info("PublicazioneServiceImpl.getPublicazione -->> La pubblicazione è stata modificata!");
			}else {
				Exception e = new Exception();
				logger.info("PublicazioneServiceImpl.update Exception -->> Tutti i campi devo essere valorisati -->> ", e);
				throw new ServiceException("Tutti i campi devo essere valorisati", e);
			}	
        } catch(Exception e) {
			logger.error("PublicazioneServiceImpl.update Exception -->> ", e);
        	throw new ServiceException(e);
        } 
		return data;
	}


	@Override
	public boolean delete(int id) throws ServiceException {
		logger.info("PublicazioneServiceImpl.delete ");
		boolean data = false;
		try {
			data = publicazineDao.delete(id);
			System.out.println("La publicazine è stato eliminato!");
			logger.info("PublicazioneServiceImpl.delete -->> La publicazine è stato eliminato!  ");
        } catch(Exception e) {
			logger.error("PublicazioneServiceImpl.delete Exception -->> ", e);
        	throw new ServiceException(e);
        }
		return data;
	}


}