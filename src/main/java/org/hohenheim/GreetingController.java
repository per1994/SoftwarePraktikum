package org.hohenheim;

import org.plp.benutzer.Benutzer;
import org.plp.benutzer.User;
import org.plp.dao.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GreetingController {
	
	@Autowired
	private BenutzerService benutzerservice;
	
	public GreetingController(){
		
	}
	
	
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String greeting(Model model) {
		
		
		
		
		Benutzer benutzer= new Benutzer();
		benutzer.setBenutzer_id(10);
		benutzer.setBenutzerName("SükrüStinkt");
		
		benutzerservice.update(benutzer);
		
		Message message= new Message();
		message.setInhat("Willkommen bei PLP, deiner SocialLearningPlattform");

		model.addAttribute("benutzer", new Benutzer());
		model.addAttribute("message",  message);
		
		return "LogIn";
	}
	
	
	
 
	
}
