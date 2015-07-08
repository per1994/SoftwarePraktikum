package org.hohenheim;

import org.plp.benutzer.Benutzer;
import org.plp.benutzer.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class NewLoginController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute Benutzer benutzer,@ModelAttribute Message message, Model model) {
	
		
		if (loginRichtig()){
		
			
			model.addAttribute("benutzer", benutzer);
			
			return "home";
		}else{
			
			message.setInhat("Falscher Login");
			model.addAttribute("message", message);
			
			return "index";
		}

		
		
	}

	private boolean loginRichtig() {
		// TODO Auto-generated method stub
		return true;
	}

}
