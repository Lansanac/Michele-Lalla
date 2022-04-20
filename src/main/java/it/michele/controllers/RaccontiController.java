package it.michele.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.michele.beans.Racconto;
import it.michele.beans.ResultMessage;
import it.michele.controllers.exceptions.ControllerException;
import it.michele.controllers.forms.PoesieForm;
import it.michele.services.RaccontiService;
import it.michele.services.exceptions.ServiceException;

@Controller
@RequestMapping("/racconti")
public class RaccontiController {

	@Autowired
	private RaccontiService raccontiService;
	private static Logger logger = Logger.getLogger(RaccontiController.class.getName());
	private static Logger loggerMail = Logger.getLogger("sendMail");
	
	@RequestMapping("/list")
	public String list(Model model) throws ControllerException {
		logger.info("RaccontiController.list ");
		String returnValue = "lista-racconti";
		try {
			List<Racconto> raccontis = raccontiService.getListaRacconto();
			model.addAttribute("racconti", raccontis);
		} catch (ServiceException e) {
			logger.error("RaccontiController.list Exception -->> ", e);
			loggerMail.error("RaccontiController.list Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}
	


	@RequestMapping(value="/getRacconto/{id}")
	public String getRacconto(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("RaccontiController.get ID: "+id);
		System.out.println("<<<<<	updateRacconti	 >>>>>  "+id);
		String returnValue = "raccontiUpdate";
		Racconto racconto = new Racconto();
		try {
			racconto = raccontiService.getRacconto(id);
			model.addAttribute("updateData", racconto);
			
		} catch (ServiceException e) {
			logger.error("RaccontiController.get Exception -->> ", e);
			loggerMail.error("RaccontiController.get Exception -->> ", e);
			throw new ControllerException(e);
		}

		return returnValue;
	}

	@RequestMapping(value="/insertRacconto", method = RequestMethod.POST)
	public String insert(Model model, @ModelAttribute("racconti") Racconto racconti, BindingResult result) throws Exception {
		logger.info("RaccontiController.insert ");
		if (result.hasErrors()) {
			logger.info("<<<<<	InsertRacconti	 ERROR		>>>>>");
			System.out.println("<<<<<	InsertRacconti	 ERROR		>>>>>");
            return "list-racconti";
        }
		System.out.println("<<<<<	InsertRacconti	 >>>>>  "+racconti);
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = raccontiService.insert(racconti);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>Il raconto é stato inserito !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>Il raconto non é stato inserito !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'> Errore durante esecuzione </h1>");
			logger.error("RaccontiController.insert Exception -->> ", e);
			loggerMail.error("RaccontiController.insert Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}

	@RequestMapping(value="/updateRacconto", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute Racconto racconto, BindingResult result, RedirectAttributes attributes) throws ControllerException {
		logger.info("RaccontiController.update ");
		if (result.hasErrors()) {
			logger.info("<<<<<	updateRacconti	 ERROR		>>>>>");
			System.out.println("<<<<<	updateRacconti	 ERROR		>>>>>");
            return "list-racconti";
        }
		System.out.println("<<<<<	updateRacconti		>>>>>  "+racconto);
		//String returnValue = "redirect:/anagrafica/get/{id}";
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = raccontiService.update(racconto);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>Il raconto é stato modificato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>Il raconto non é stato modificato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
			System.out.println("<<<<<	updateRacconti	 >>>>>  "+data);
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("RaccontiController.update Exception -->> ", e);
			loggerMail.error("RaccontiController.update Exception -->> ", e);
			throw new ControllerException(e);
		}		

		return returnValue;
	}

	@RequestMapping(value="/deletRacconto/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("RaccontiController.delete ID: "+id);
		System.out.println("<<<<<	deletRacconto		>>>>>  "+id);
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = raccontiService.delete(id);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>Il raconto é stato eliminato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>Il raconto non é stato eliminato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());

		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("RaccontiController.delete Exception -->> ", e);
			loggerMail.error("RaccontiController.delete Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}

}
