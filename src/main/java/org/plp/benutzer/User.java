package org.plp.benutzer;

import org.springframework.ui.Model;

public class User {
	public String Name = "";
	public String Password = "";
	
	public void HinzufügenZuModel(Model model){
		model.addAttribute("userName", Name);
		model.addAttribute("userPassword", Password);
	}
}
