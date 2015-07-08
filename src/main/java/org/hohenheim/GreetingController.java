package org.hohenheim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController {
	
	private LoginController _loginController;
	
	public GreetingController(){
		_loginController = new LoginController();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String greeting(
		//	@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			@RequestParam(value = "benutzerName", required = false, defaultValue = "") String benutzerName,
			@RequestParam(value = "passwort", required = false, defaultValue = "") String passwort,
			@RequestParam(value = "action", required = false, defaultValue = "index") String page,
			Model model) {

		if(page.equals("login")){
			return _loginController.processAccessRequest(model, benutzerName, passwort);
		}
		return page;
	}
}
