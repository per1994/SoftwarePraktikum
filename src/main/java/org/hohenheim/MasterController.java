package org.hohenheim;

import java.util.List;

import org.plp.benutzer.Benutzer;
import org.plp.dao.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class MasterController {
	
	Benutzer aktiverBenutzer;
	
	@Autowired
	BenutzerService benutzerservice;
	
	
	
	@RequestMapping(value="/")
	public String begin (Model model){
		
		model.addAttribute("benutzer", new Benutzer());
		model.addAttribute("message", "Willkommen bei PLP, deiner Social-Learning-Platform");
		
		return "LogIn";
		
		
		
		
		
	}
	
	@RequestMapping(value="/registrieren", method=RequestMethod.POST)
	public String registrieren(@ModelAttribute Benutzer benutzer, Model model){
		
		
		
	}
	
	
	
	@RequestMapping(value="/anmelden", method=RequestMethod.POST)
	public String anmelden(@ModelAttribute Benutzer benutzer, Model model){
		
		List<Benutzer>alleBenutzer=benutzerservice.listAllBenutzer();
		
		int benutzerid=0;
		boolean benutzerVorhanden=false;
		
		for (Benutzer b: alleBenutzer){
			
			if (b.getBenutzerName().equals(benutzer.getBenutzerName())){
				
				benutzerid=b.getBenutzer_id();
				benutzerVorhanden=true;
				
			}
			
		}
		
		if(benutzerVorhanden){
			
			if(benutzer.getPasswort().equals(benutzerservice.getBenutzer(benutzerid).getPasswort())){
				
				aktiverBenutzer=benutzerservice.getBenutzer(benutzerid);
				model.addAttribute("aktiverBenutzer", aktiverBenutzer);
				return "home";
				
			}else{
				model.addAttribute("message", "Falsches Passwort");
				return "LogIn";
			}
			
		}else{
			model.addAttribute("message", "Falscher Benutzername");
			return "LogIn";
		}
		
		
	}
	
	
	

}
