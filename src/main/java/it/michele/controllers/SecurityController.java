package it.michele.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.michele.security.SecurityConfig;



@Controller
public class SecurityController {
	
	private static final AuthenticationManagerBuilder AuthenticationManagerBuilder = null;
	
	@Autowired
	SecurityConfig securityConfig;
	
	
	/*@RequestMapping(value = "/spring-mvc-login", method= RequestMethod.GET)
    public String sayHello(){
        return "login";
    }

   @RequestMapping(value = "/spring-mvc-login", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String name, @RequestParam String password,
                                     ModelMap modelMap){
    modelMap.put("name",name);
    modelMap.put("password", password);
    return "welcome";

    }
	*/
	
	/*@RequestMapping("/login")
	public String login(Model model, @ModelAttribute Users user, BindingResult result) {
		//securityConfig.configure(null);
		//Users users = new Users();
		System.out.println("SecurityController.login");
		System.out.println("Username -->	"+user.getUsername()+"	Password -->	"+user.getPassword());
		if (result.hasErrors()) {
			System.out.println("<<<<<	Login ERROR		>>>>>");
            return "/index";
        }
		try {
			securityConfig.configure(AuthenticationManagerBuilder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}*/
	
	@RequestMapping("/login")
	public String login(Principal principal) {
		//System.out.println("Username -->	"+user.getUsername()+"	Password -->	"+user.getPassword());

        if (principal!=null && ((Authentication)principal).isAuthenticated()) {
        	System.out.println("Sei loggato");
            return "redirect:/index";
        }else {
        	System.out.println("Non sei loggato");
            return "index";
        }
	}
	
	@RequestMapping("/")
	public String home() {
		return "/index";
	}
	
	@RequestMapping(value="/403")
	public String accessofallito() {
		return "403";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, String error, String logout) throws Exception {
		System.out.println("SecurityController.login");
        if (error != null)
            model.addAttribute("error", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("logout", "You have been logged out successfully.");
        

        
        return "redirect:/index";
    }
	/*@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "redirect:/index";
	}*/
	
}
