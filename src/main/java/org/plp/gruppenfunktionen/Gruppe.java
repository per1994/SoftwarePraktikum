package org.plp.gruppenfunktionen;

import java.util.ArrayList;

public class Gruppe {

	private ArrayList mitgliederListe = new ArrayList ();
	private ArrayList moderatorenListe = new ArrayList ();
	private int anzahlMitglieder = 0;
	private Fachrichtung fachrichtung = new Fachrichtung();
	private double lernFortschritt = 0.0;
	private String name;
	private int id = 0;
	private String passwort;
	private ArrayList lernziele = new ArrayList();
	private Lernziel lernziel = new Lernziel();
	public ArrayList getMitgliederListe() {
		return mitgliederListe;
	}
	public void setMitgliederListe(ArrayList mitgliederListe) {
		this.mitgliederListe = mitgliederListe;
	}
	public ArrayList getModeratorenListe() {
		return moderatorenListe;
	}
	public void setModeratorenListe(ArrayList moderatorenListe) {
		this.moderatorenListe = moderatorenListe;
	}
	public int getAnzahlMitglieder() {
		return anzahlMitglieder;
	}
	public void setAnzahlMitglieder(int anzahlMitglieder) {
		this.anzahlMitglieder = anzahlMitglieder;
	}
	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}
	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}
	public double getLernFortschritt() {
		return lernFortschritt;
	}
	public void setLernFortschritt(double lernFortschritt) {
		this.lernFortschritt = lernFortschritt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public ArrayList getLernziele() {
		return lernziele;
	}
	public void setLernziele(ArrayList lernziele) {
		this.lernziele = lernziele;
	}
	public Lernziel getLernziel() {
		return lernziel;
	}
	public void setLernziel(Lernziel lernziel) {
		this.lernziel = lernziel;
	}
	
	
	
}
