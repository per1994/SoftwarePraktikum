package org.plp.benutzer;

import java.util.ArrayList;

public class Eintrag {
	
	private String eintragstext;
	private ArrayList<String> kommentare;
	
	
	public void erscheintAufPinnwand(Pinnwand pinnwand){
		pinnwand.getEinträge().add(this);
		pinnwand.setNeueEinträge(pinnwand.getNeueEinträge()+1);
	}
	
	
	
	public String getEintragstext() {
		return eintragstext;
	}
	public void setEintragstext(String eintragstext) {
		this.eintragstext = eintragstext;
	}
	public ArrayList<String> getKommentare() {
		return kommentare;
	}
	public void setKommentare(ArrayList<String> kommentare) {
		this.kommentare = kommentare;
	}

}
