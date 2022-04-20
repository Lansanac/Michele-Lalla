package it.michele.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.michele.beans.Biografia;
import it.michele.beans.Contatto;
import it.michele.beans.Poesie;
import it.michele.beans.Pubblicazione;
import it.michele.beans.ResultMessage;
import it.michele.controllers.exceptions.ControllerException;
import it.michele.services.PublicazioeService;
import it.michele.services.PublicazioneServiceImpl;
import it.michele.services.exceptions.ServiceException;


@Controller
public class PubblicazioniController {

	@Autowired
	PublicazioeService publicazioneService;
	private static Logger logger = Logger.getLogger(PubblicazioniController.class.getName());
	private static Logger loggerMail = Logger.getLogger("sendMail");
	
	@RequestMapping(value="/pubblicazioni")
	public String home(Model model) {
		// da aggiungere qualcosa
		return "lista-pubblicazioni";
	}
	
	@RequestMapping(value="/pubblicazioni/list")
	public String list(Model model) {
		BasicConfigurator.configure();
		logger.info("PublicazioneServiceImpl.list ");
		String returnValue = "lista-pubblicazioni";
		List<Pubblicazione> pubblicaziones =  new ArrayList<Pubblicazione>(); 
		try {
			pubblicaziones = publicazioneService.getListPubblicazione();
			model.addAttribute("pubblicazione", pubblicaziones);
			System.out.println("<<<<<	Pubblicazioni	 >>>>>  "+pubblicaziones);
			logger.info("PublicazioneServiceImpl.list "+pubblicaziones);
		}catch (Exception e) {
			model.addAttribute(returnValue, e.getMessage());
			logger.error("PublicazioneServiceImpl.list Exception -->> ", e);
			loggerMail.error("PublicazioneServiceImpl.list Exception -->> ", e);
		}
			
		return returnValue;
	}
	
	@RequestMapping("/pubblicazioni/dettaglio/{id}")
	public String dettaglio(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("PublicazioneServiceImpl.dettaglio ID: "+id);

		System.out.println("<<<<<	dettaglio pubblicazione	 >>>>>  "+id);
		String returnValue = "pubDettaglio";
		Pubblicazione publPubblicazione = new Pubblicazione();
		try {
			publPubblicazione = publicazioneService.getPublicazione(id);
			model.addAttribute("dettaglio", publPubblicazione);
			
		} catch (ServiceException e) {
			logger.error("PublicazioneServiceImpl.dettaglio Exception -->> ", e);
			loggerMail.error("PublicazioneServiceImpl.dettaglio Exception -->> ", e);

			throw new ControllerException(e);
		}
		
		return returnValue;
	}
	
	@RequestMapping("/pubblicazioni/insert")
	public String insert(Model model, @ModelAttribute Pubblicazione pubblicazione, BindingResult result) throws ControllerException {
		logger.info("PublicazioneServiceImpl.insert ");
		String returnValue = "resultMessage";

		if (result.hasErrors()) {
			System.out.println("<<<<<	InsertPublicazione	 ERROR		>>>>>");
			logger.info("PublicazioneServiceImpl.insert <<<<<	InsertPublicazione	 ERROR		>>>>>");
			loggerMail.error("PublicazioneServiceImpl.insert <<<<<	InsertPublicazione	 ERROR		>>>>>");
            return "lista-pubblicazioni";
        }
		System.out.println("<<<<<	InsertPublicazione	 >>>>>  "+pubblicazione);
		logger.info("PublicazioneServiceImpl.insert <<<<<	InsertPublicazione	 >>>>>  "+pubblicazione);
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = publicazioneService.insert(pubblicazione);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La pubblicazione é stato inserito !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La pubblicazione non é stato inserito !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PublicazioneServiceImpl.insert Exception -->> ", e);
			loggerMail.error("PublicazioneServiceImpl.insert Exception -->> ", e);
			throw new ControllerException(e);
		}
		
		return returnValue;
	}

	@RequestMapping("/pubblicazioni/getPubblicazione/{id}")
	public String openUpdate(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("PublicazioneServiceImpl.openUpdate ID"+id);

		System.out.println("<<<<<	updatePoesia	 >>>>>  "+id);
		String returnValue = "pubUpdate";
		Pubblicazione publPubblicazione = new Pubblicazione();
		try {
			publPubblicazione = publicazioneService.getPublicazione(id);
			model.addAttribute("pubData", publPubblicazione);
			
		} catch (ServiceException e) {
			model.addAttribute("pubData", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PublicazioneServiceImpl.openUpdate Exception -->> ", e);
			loggerMail.error("PublicazioneServiceImpl.openUpdate Exception -->> ", e);
			throw new ControllerException(e);
		}
		
		return returnValue;
	}

	@RequestMapping(value="/pubblicazioni/update")
	public String update(Model model, @ModelAttribute Pubblicazione pubblicazione, BindingResult result, RedirectAttributes attributes) throws ControllerException {
		logger.info("PublicazioneServiceImpl.update ");
		if (result.hasErrors()) {
			System.out.println("<<<<<	PubblicazioneUpdate	 ERROR		>>>>>");
			logger.info("PublicazioneServiceImpl.update <<<<<	PubblicazioneUpdate	 ERROR		>>>>>");
			loggerMail.error("PublicazioneServiceImpl.update <<<<<	PubblicazioneUpdate	 ERROR		>>>>>");
	        return "lista-pubblicazioni";
	    }
		System.out.println("<<<<<	PubblicazioneUpdate	 >>>>>  "+pubblicazione);
		logger.info("PublicazioneServiceImpl.update <<<<<	PubblicazioneUpdate		>>>>>");
		ResultMessage reslteMessage = new ResultMessage();
		String returnValue = "resultMessage";
		try {
			boolean data = publicazioneService.update(pubblicazione);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La pubblicazione é stato modificato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La pubblicazione non é stato modificato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PublicazioneServiceImpl.update Exception -->> ", e);
			loggerMail.error("PublicazioneServiceImpl.update Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}

	@RequestMapping("/pubblicazioni/delet/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("PublicazioneServiceImpl.delete ID"+id);

		System.out.println("<<<<<	deletPubblicazioni	>>>>>  "+id);
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = publicazioneService.delete(id);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La pubblicazione é stato eliminato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La pubblicazione non é stato eliminato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PublicazioneServiceImpl.delete Exception -->> ", e);
			loggerMail.error("PublicazioneServiceImpl.delete Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}

}