package it.michele.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.michele.beans.Biografia;
import it.michele.beans.Opere;
import it.michele.beans.Premiazioni;
import it.michele.beans.ResultMessage;
import it.michele.controllers.exceptions.ControllerException;
import it.michele.dao.PublicazioneDaoImpl;
import it.michele.services.BiografiaService;
import it.michele.services.OpereService;
import it.michele.services.exceptions.ServiceException;


@Controller
@RequestMapping("/biografia")
public class BiografiaController {
	
    private static Logger logger = Logger.getLogger(BiografiaController.class);
	private static Logger loggerMail = Logger.getLogger("sendMail");
	
	@Autowired
	private OpereService opereService;
	@Autowired
	private BiografiaService biografiaService;
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		logger.info("BiografiaController.list ");
		String returnValue = "biografia";
		List<Opere> operes =  new ArrayList<Opere>(); 
		List<Premiazioni> premiazionis = new ArrayList<Premiazioni>();
		Biografia biografia = new Biografia();
		try {
			
			//premiazionis = biografiaService.getListaPremiazioni();
			operes = opereService.getListaOpere();
			
			biografia.setOperes(operes);
			biografia.setPremiazionis(premiazionis);
			model.addAttribute("opere", operes);
			System.out.println("<<<<<	OPERE	 >>>>>  "+operes);

			list(model,  premiazionis);
		}catch (Exception e) {
			logger.error("BiografiaController.list Exception -->> ", e);
			loggerMail.error("BiografiaController.list Exception -->> ", e);
			model.addAttribute("error-message", e.getMessage());
		}
			
		return returnValue;
	}
	
	@RequestMapping(value="/premiazioni")
	public void list(Model model, List<Premiazioni> premiazionis) throws ServiceException {
//		String returnValue = "biografia";
		logger.info("BiografiaController.listBiss ");
		
		premiazionis = biografiaService.getListaPremiazioni();
		model.addAttribute("premiazioni", premiazionis);
		
	}
	
	
	
	@RequestMapping("/insert")
	public String insert(Model model, @ModelAttribute Premiazioni premiazioni, BindingResult result) throws ControllerException {
		logger.info("BiografiaController.insert ");
		String returnValue = "resultMessage";
		if (result.hasErrors()) {
			System.out.println("<<<<<	InsertPremiazioni	 ERROR		>>>>>");
			logger.info("<<<<<	InsertPremiazioni	 ERROR		>>>>>");
            return returnValue;
        }
		System.out.println("<<<<<	InsertPremiazioni	 >>>>>  "+premiazioni);
		//List<Premiazioni> premiazionis = new ArrayList<Premiazioni>();
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = biografiaService.insert(premiazioni);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'> La premiazione é stato inserito !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'> La premiazione non é stato inserito !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
//			model.addAttribute("data", data);
//			model.addAttribute("premiazioni", premiazionis);
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.insert Exception -->> ", e);
			loggerMail.error("BiografiaController.insert Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}
	
	@RequestMapping("/opera/insert")
	public String insertOpere(Model model, @ModelAttribute Opere opere, BindingResult result) throws ControllerException {
		logger.info("BiografiaController.insertOpere ");
		
		if (result.hasErrors()) {
			System.out.println("<<<<<	insertOpere	 ERROR		>>>>>");
			logger.info("<<<<<	insertOpere	 ERROR		>>>>> ");
            return "opere";
        }
		System.out.println("<<<<<	insertOpere	 >>>>>  "+opere);
		List<Opere> operes = new ArrayList<Opere>();
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = biografiaService.insertOpere(opere);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>L'opere é stato inserito !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>L'opere non é stato inserito !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
//			model.addAttribute("data", data);
//			model.addAttribute("opere", operes);
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.insertOpere Exception -->> ", e);
			loggerMail.error("BiografiaController.insertOpere Exception -->> ", e);
			throw new ControllerException(e);
		}
		
		return returnValue;
	}
	
	@RequestMapping("/openUpdate/{id}")
	public String openUpdate(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("BiografiaController.openUpdate "+id);
		System.out.println("<<<<<	updatePremiazioni	 >>>>>  "+id);
		List<Premiazioni> premiazionis = new ArrayList<Premiazioni>();
		String returnValue = "premiazioneUpdate";
		Premiazioni premiazioni = new Premiazioni();
		try {
			premiazioni = biografiaService.getPremiazioni(id);
			model.addAttribute("premiazioniData", premiazioni);
			//model.addAttribute("premiazioni", premiazionis);
		} catch (ServiceException e) {
			model.addAttribute("premiazioniData", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.openUpdate Exception -->> ", e);
			loggerMail.error("BiografiaController.openUpdate Exception -->> ", e);
			throw new ControllerException(e);
		}
		
		return returnValue;
	}
	
	@RequestMapping("/opera/openUpdate/{id}")
	public String openUpdateOpere(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("BiografiaController.openUpdateOpere "+id);
		System.out.println("<<<<<	updateOpere	 >>>>>  "+id);
		List<Opere> operes = new ArrayList<Opere>();
		String returnValue = "operaUpdate";
		Opere opere = new Opere();
		try {
			opere = biografiaService.getOpere(id);
			System.out.println("<<<<<	openOpere	 >>>>>  "+opere);
			model.addAttribute("operaData", opere);
			model.addAttribute("opere", operes);
		} catch (ServiceException e) {
			model.addAttribute("opere", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.openUpdateOpere Exception -->> ", e);
			loggerMail.error("BiografiaController.openUpdateOpere Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}

	@RequestMapping(value="/update")
	public String update(Model model, @ModelAttribute Premiazioni premiazioni, BindingResult result, RedirectAttributes attributes) throws ControllerException {
		logger.info("BiografiaController.update ");
		if (result.hasErrors()) {
			System.out.println("<<<<<	PremiazioniUpdate	 ERROR		>>>>>");
	        return "lista-poesie";
	    }
		System.out.println("<<<<<	PremiazioniUpdate	 >>>>>  "+premiazioni);
		logger.info("<<<<<	PremiazioniUpdate	 >>>>>  "+premiazioni);
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = biografiaService.update(premiazioni);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La premiazione é stato modificato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La premiazione non é stato modificato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.update Exception -->> ", e);
			loggerMail.error("BiografiaController.update Exception -->> ", e);
			throw new ControllerException(e);
		}
			
		return returnValue;
	}
	
	@RequestMapping(value="/opera/update")
	public String updateOpere(Model model, @ModelAttribute Opere opere, BindingResult result, RedirectAttributes attributes) throws ControllerException {
		logger.info("BiografiaController.updateOpere ");
		if (result.hasErrors()) {
			logger.info("<<<<<	OpereUpdate	 ERROR		>>>>>");
			System.out.println("<<<<<	OpereUpdate	 ERROR		>>>>>");
	        return "lista-poesie";
	    }
		System.out.println("<<<<<	OpereUpdate	 >>>>>  "+opere);
		logger.info("<<<<<	OpereUpdate		>>>>>  "+opere);
		List<Premiazioni> premiazionis = new ArrayList<Premiazioni>();
		String returnValue = "resultMessage";
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = biografiaService.updateOpere(opere);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>L'opera é stato modificato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>L'opera non é stato modificato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
			//model.addAttribute("premiazioni", premiazionis);
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.updateOpere Exception -->> ", e);
			loggerMail.error("BiografiaController.updateOpere Exception -->> ", e);
			throw new ControllerException(e);
		}
			
		return returnValue;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("BiografiaController.delete "+id);
		System.out.println("<<<<<	deletPremiazione		>>>>>  "+id);
		String returnValue = "resultMessage";
		List<Premiazioni> premiazionis = new ArrayList<Premiazioni>();
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = biografiaService.delete(id);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>La premiazione é stato Eliminato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>La premiazione non é stato Eliminato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
			//model.addAttribute("premiazioni", premiazionis);

		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.delete Exception -->> ", e);
			loggerMail.error("BiografiaController.delete Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}
	
	@RequestMapping("/opera/delete/{id}")
	public String deleteOpere(@PathVariable("id") Integer id, Model model) throws ControllerException {
		logger.info("BiografiaController.deleteOpere "+id);
		System.out.println("<<<<<	deletOpere		>>>>>  "+id);
		String returnValue = "resultMessage";
		List<Premiazioni> premiazionis = new ArrayList<Premiazioni>();
		ResultMessage reslteMessage = new ResultMessage();
		try {
			boolean data = biografiaService.deleteOpere(id);
			if(data) {
				reslteMessage.setMessage("<h1 style='color:green;'>L'opera é stato Eliminato !!!</h1>");
			}else {
				reslteMessage.setMessage("<h1 style='color:red;'>L'opera non é stato Eliminato !!!</h1>");
			}
			model.addAttribute("data", reslteMessage.getMessage());
			//model.addAttribute("premiazioni", premiazionis);
		} catch (ServiceException e) {
			model.addAttribute("data", "<h1 style='color:red;'>Errore durante esecuzione</h1>");
			logger.error("BiografiaController.deleteOpere Exception -->> ", e);
			loggerMail.error("BiografiaController.deleteOpere Exception -->> ", e);
			throw new ControllerException(e);
		}
		return returnValue;
	}

	
}