package it.michele.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.michele.beans.Pubblicazione;
import it.michele.services.PublicazioeService;


@Controller
public class IndexController {

	@Autowired
	PublicazioeService publicazioneService;
	private static Logger logger = Logger.getLogger(PubblicazioniController.class.getName());
	private static Logger loggerMail = Logger.getLogger("sendMail");
	
	@RequestMapping(value="/index")
	public String home(Model model) {
		
		BasicConfigurator.configure();
		logger.info("IndexController.list ");
		String returnValue = "index";
		List<Pubblicazione> pubblicaziones =  new ArrayList<Pubblicazione>(); 
		try {
			pubblicaziones = publicazioneService.getTitolo();
			String titoli = "";
			for (Pubblicazione pubblicazione : pubblicaziones) {
				titoli += pubblicazione.getTitolo()+", ";
			}
			model.addAttribute("pubblicazioni", titoli);
			System.out.println("<<<<<	Pubblicazioni	 >>>>>  "+titoli);
			logger.info("IndexController -- Publicazione.list "+pubblicaziones);
		}catch (Exception e) {
			model.addAttribute(returnValue, e.getMessage());
			logger.error("IndexController.list Exception -->> ", e);
			loggerMail.error("IndexController.list Exception -->> ", e);
		}
			
		return returnValue;
		
	}
	/*
	@RequestMapping(value="/home")
	public String home(Model model) {
		
		// da aggiungere qualcosa
		
		return "PROVA";
	}*/
}