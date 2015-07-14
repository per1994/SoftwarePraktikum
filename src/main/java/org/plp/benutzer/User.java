package org.plp.benutzer;

import org.springframework.ui.Model;

public class User {
	private String Name = "";
	private String Password = "";

	public void HinzufügenZuModel(Model model) {
		model.addAttribute("userName", Name);
		model.addAttribute("userPassword", Password);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
