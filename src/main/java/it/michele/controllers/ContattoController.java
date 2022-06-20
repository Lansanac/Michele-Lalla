package it.michele.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.michele.beans.Biografia;
import it.michele.beans.Contatto;
import it.michele.beans.Opere;
import it.michele.beans.Premiazioni;
import it.michele.controllers.exceptions.ControllerException;
import it.michele.services.ContattoService;
import it.michele.services.exceptions.ServiceException;


@Controller
public class ContattoController {
	
    @Autowired
    private ContattoService contattoService;
	private static Logger logger = Logger.getLogger(ContattoController.class.getName());
	private static Logger loggerMail = Logger.getLogger("sendMail");

    @RequestMapping(value="/contattoPage")
	public String contatto(Model model) {
		// da aggiungere qualcosa
		return "contattoPage";
	}
    
    @RequestMapping(value="/contattoPage/list")
	public String list(Model model) {
    	logger.info("ContattoController.list ");
		String returnValue = "contattoPage";
		List<Contatto> contattos =  new ArrayList<Contatto>(); 
		Biografia biografia = new Biografia();
		try {
			//premiazionis = biografiaService.getListaPremiazioni();
			contattos = contattoService.getListContatto();
			model.addAttribute("contatti", contattos);
			logger.info(" <<<<<	 Contattos	 >>>>>  "+contattos);
		}catch (Exception e) {
			logger.error("ContattoController.list Exception -->> ", e);
			loggerMail.error("ContattoController.list Exception -->> ", e);
			model.addAttribute("error-message", e.getMessage());
		}
			
		return returnValue;
	} 

	@RequestMapping(value ="/messaggio", method = RequestMethod.POST)
	public String sendMessage(Model model, @ModelAttribute Contatto contatto, HttpServletRequest request, HttpServletResponse response) throws ControllerException, ServiceException, ControllerException {
		logger.info("ContattoController.sendMessage ");
		String returnValue = "resultMessage";
		System.out.println(contatto.toString());
		controlEmail(contatto) ;
		
		try {
			contattoService.insert(contatto);
			contattoService.sendSimpleMessage(contatto, request, response);
			model.addAttribute("data", "<h1 style='color:green;'>Il messaggio è stato mandato con successo!</h1>");
		}catch (Exception e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("ContattoController.sendMessage Exception -->> ", e);
			loggerMail.error("ContattoController.sendMessage Exception -->> ", e);
			model.addAttribute("data", "Il messaggio non è stato mandato. Riprova per favore!");
		}
		return returnValue;
	}

	private void controlEmail(Contatto contatto) throws ControllerException {
		if(contatto.getEmail().isEmpty() || contatto.getSoggetto().isEmpty() || contatto.getNome().isEmpty() || contatto.getMessaggio().isEmpty()) {
			logger.error("ContattoController.sendMessage Exception -->> Tutti campi sono obligatori!! ");
			throw new ControllerException("Tutti campi sono obligatori!!");
		}
	}
	
}