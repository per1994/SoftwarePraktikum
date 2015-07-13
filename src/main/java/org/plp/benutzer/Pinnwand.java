package org.plp.benutzer;

import java.util.ArrayList;

public class Pinnwand {

	private ArrayList<Eintrag> einträge;

	public Pinnwand() {
		einträge = new ArrayList();
	}

	public ArrayList<Eintrag> getEinträge() {
		return einträge;
	}

	public void setEinträge(ArrayList<Eintrag> einträge) {
		this.einträge = einträge;
	}

}
