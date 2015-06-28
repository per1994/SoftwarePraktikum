package org.hohenheim;

import org.springframework.ui.Model;
import org.plp.benutzer.User;

public class LoginController {


	
	public String processAccessRequest(Model model, String userName, String password){
		
		if(!userAndPasswordIsValid(userName, password)){
			return "error";
		}
		
		User user = new User();
		user.Password = password;
		user.Name = userName;
		
		user.HinzufügenZuModel(model);
		
		return "home";
	}

	private boolean userAndPasswordIsValid(String userName, String password) {
		return true;
	}
	
	
}
