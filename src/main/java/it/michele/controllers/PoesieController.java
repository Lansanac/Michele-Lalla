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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.michele.beans.Poesie;
import it.michele.beans.Racconto;
import it.michele.beans.ResultMessage;
import it.michele.controllers.exceptions.ControllerException;
import it.michele.controllers.forms.PoesieForm;
import it.michele.services.PoesieService;
import it.michele.services.exceptions.ServiceException;

@Controller
@RequestMapping("/poesia")
public class PoesieController {

	@Autowired
	private PoesieService poesieService;
	private static Logger logger = Logger.getLogger(PoesieController.class.getName());
	private static Logger loggerMail = Logger.getLogger("sendMail");
	
	//@SuppressWarnings("null")
	@RequestMapping("/list")
	public String list(Model model) throws ControllerException {
		logger.info("PoesieController.list ");
		String returnValue = "lista-poesie";
		try {
			List<Poesie> poesie = poesieService.getListaPoesie();
			//System.out.println("poesie --->	"+poesie);
			model.addAttribute("poesie", poesie);
		} catch (ServiceException e) {
			logger.error("PoesieController.list Exception -->> ", e);
			loggerMail.error("PoesieController.list Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}


	@RequestMapping("/insertPoesia")
	public String insert(Model model, @ModelAttribute Poesie poesie, BindingResult result) throws ControllerException {
		logger.info("PoesieController.insert ");
		
		if (result.hasErrors()) {
			logger.info("<<<<<	InsertPoesia	 ERROR		>>>>>");
			System.out.println("<<<<<	InsertPoesia	 ERROR		>>>>>");
            return "lista-poesie";
        }
		System.out.println("<<<<<	InsertRacconti	 >>>>>  "+poesie);
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = poesieService.insert(poesie);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La poesia é stato inserito !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La poesia non é stato inserito !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PoesieController.list Exception -->> ", e);
			loggerMail.error("PoesieController.list Exception -->> ", e);
			throw new ControllerException(e);
		}
		
		

		return returnValue;
	}

	@RequestMapping("/openUpdate/{id}")
	public String openUpdate(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("PoesieController.openUpdate ID:"+id);
		System.out.println("<<<<<	updatePoesia	 >>>>>  "+id);
		String returnValue = "poesiaUpdate";
		Poesie poesie = new Poesie();
		try {
			poesie = poesieService.getPoesie(id);
			model.addAttribute("poesiaData", poesie);
			
		} catch (ServiceException e) {
			model.addAttribute("poesiaData", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PoesieController.openUpdate Exception -->> ", e);
			loggerMail.error("PoesieController.openUpdate Exception -->> ", e);
			throw new ControllerException(e);
		}
		
		return returnValue;
	}

	@RequestMapping(value="/update")
	public String update(Model model, @ModelAttribute Poesie poesie, BindingResult result, RedirectAttributes attributes) throws ControllerException {
		logger.info("PoesieController.update ");
		if (result.hasErrors()) {
			logger.info("<<<<<	PoesiaUpdate	 ERROR		>>>>>");
			System.out.println("<<<<<	PoesiaUpdate	 ERROR		>>>>>");
	        return "lista-poesie";
	    }
		System.out.println("<<<<<	PoesiaUpdate	 >>>>>  "+poesie);
		logger.info("<<<<<	PoesiaUpdate		>>>>>"+poesie);
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = poesieService.update(poesie);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La poesia é stato modificato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La poesia non é stato modificato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PoesieController.update Exception -->> ", e);
			loggerMail.error("PoesieController.update Exception -->> ", e);
			throw new ControllerException(e);
		}
			
		return returnValue;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("PoesieController.delete ID: "+id);
		System.out.println("<<<<<	deletPoesia		>>>>>  "+id);
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = poesieService.delete(id);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La poesia é stato eliminato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La poesia non é stato eliminato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("PoesieController.delete Exception -->> ", e);
			loggerMail.error("PoesieController.delete Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}

}
