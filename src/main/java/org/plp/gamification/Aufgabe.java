package org.plp.gamification;

import java.util.HashSet;

import org.plp.benutzer.Benutzer;
import org.plp.gruppenfunktionen.Fachrichtung;

public class Aufgabe {

	private Benutzer aufgabenAutor;
	private HashSet<Teilaufgabe> teilAufgaben = new HashSet<Teilaufgabe>();
	private int punktzahl;
	private Fachrichtung fachrichtung;
	private String themengebiet;

	
	
	public Benutzer getAufgabenAutor() {
		return aufgabenAutor;
	}

	public void setAufgabenAutor(Benutzer aufgabenAutor) {
		this.aufgabenAutor = aufgabenAutor;
	}

	public HashSet<Teilaufgabe> getTeilAufgaben() {
		return teilAufgaben;
	}

	public void setTeilAufgaben(HashSet<Teilaufgabe> teilAufgaben) {
		this.teilAufgaben = teilAufgaben;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public String getThemengebiet() {
		return themengebiet;
	}

	public void setThemengebiet(String themengebiet) {
		this.themengebiet = themengebiet;
	}
	
	

}
