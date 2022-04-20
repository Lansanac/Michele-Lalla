package it.michele.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	
	@RequestMapping(value="/index")
	public String home(Model model) {
		
		// da aggiungere qualcosa
		
		return "index";
	}
	/*
	@RequestMapping(value="/home")
	public String home(Model model) {
		
		// da aggiungere qualcosa
		
		return "PROVA";
	}*/
}