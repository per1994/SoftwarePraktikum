package org.plp.gamification;

import java.util.HashSet;

public class Teilaufgabe {

	private String frage;
	private HashSet<String> antwortMöglichkeiten = new HashSet<String>();
	private int punktzahl;

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public HashSet<String> getAntwortMöglichkeiten() {
		return antwortMöglichkeiten;
	}

	public void setAntwortMöglichkeiten(HashSet<String> antwortMöglichkeiten) {
		this.antwortMöglichkeiten = antwortMöglichkeiten;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

}
