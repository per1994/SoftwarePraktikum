package org.plp.gamification;

import java.util.HashSet;

public class Teilaufgabe {

	private String frage;
	private HashSet<String> antwortM�glichkeiten = new HashSet<String>();
	private int punktzahl;

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public HashSet<String> getAntwortM�glichkeiten() {
		return antwortM�glichkeiten;
	}

	public void setAntwortM�glichkeiten(HashSet<String> antwortM�glichkeiten) {
		this.antwortM�glichkeiten = antwortM�glichkeiten;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

}
