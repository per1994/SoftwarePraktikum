package org.plp.benutzer;

import java.util.ArrayList;

public class Eintrag {
	
	String eintragstext;
	ArrayList<String> kommentare;
	
	
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
