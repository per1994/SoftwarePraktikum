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
@RequestMapping(value = "/Gruppenliste")
public class GruppenlisteController {

	@RequestMapping(method = RequestMethod.GET)
	public String greeting(Model model) {
		return "Gruppenliste";
	}

}
