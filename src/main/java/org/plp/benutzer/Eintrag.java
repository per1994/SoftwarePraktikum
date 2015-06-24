package org.plp.benutzer;

import java.util.ArrayList;

public class Eintrag<T> {

	private String eintragsText;
	private ArrayList<T> kommentare;

	public String getEintragsText() {
		return eintragsText;
	}

	public void setEintragsText(String eintragsText) {
		this.eintragsText = eintragsText;
	}

	public ArrayList<T> getKommentare() {
		return kommentare;
	}

	public void setKommentare(ArrayList<T> kommentare) {
		this.kommentare = kommentare;
	}
}
