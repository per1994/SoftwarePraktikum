package org.hohenheim;

import org.plp.benutzer.Benutzer;
import org.plp.benutzer.User;
import org.plp.dao.BenutzerService;
import org.plp.dao.GruppeService;
import org.plp.dao.NachrichtService;
import org.plp.grundfunktionen.Freundschaftsanfrage;
import org.plp.grundfunktionen.Nachrichtengenerator;
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

	@Autowired
	private GruppeService gruppenservice;

	@Autowired
	private NachrichtService nachrichtservice;

	@Autowired
	Nachrichtengenerator nachrichtengenerator;

	public GreetingController() {

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String greeting(Model model) {

		nachrichtengenerator.ertsellFreundschaftsanfrage(59, 50, 49, false,
				false);

		Message message = new Message();
		message.setInhat("Willkommen bei PLP, deiner SocialLearningPlattform");

		model.addAttribute("benutzer", new Benutzer());
		model.addAttribute("message", message);

		return "LogIn";
	}

}
