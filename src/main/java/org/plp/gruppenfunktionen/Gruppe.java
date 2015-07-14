package org.plp.gruppenfunktionen;

import org.plp.benutzer.*;
import java.util.ArrayList;

public class Gruppe {

	private ArrayList<Benutzer> mitgliederListe = new ArrayList<Benutzer>();
	private int anzahlMitglieder = mitgliederListe.size();
	private Fachrichtung fachrichtung = new Fachrichtung();
	private double lernFortschritt = 0.0;
	private String name;
	private int id = 0;
	private String passwort;
	private ArrayList<Lernziel> lernziele = new ArrayList<Lernziel>();
	private Lernziel lernziel = new Lernziel();

	public ArrayList<Benutzer> getMitgliederListe() {
		return mitgliederListe;
	}

	public void addMitgliedToMitgliederListe(Benutzer benutzer)
			throws Exception {
		if (mitgliederListe.contains(benutzer)) {
			throw new Exception("Benutzer ist bereits Mitglied!");
		} else {
			mitgliederListe.add(benutzer);
		}
	}

	public void removeMitgliedFromMitgliederListe(Benutzer benutzer)
			throws Exception {
		if (!mitgliederListe.contains(benutzer)) {
			throw new Exception("Benutzer ist nicht Mitglied!");
		} else {
			mitgliederListe.remove(benutzer);
		}
	}

	public int getAnzahlMitglieder() {
		return anzahlMitglieder;
	}

	public void setAnzahlMitglieder(ArrayList<Benutzer> mitgliederListe) {
		this.anzahlMitglieder = mitgliederListe.size();
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

	public ArrayList<Lernziel> getLernziele() {
		return lernziele;
	}

	public void addLernzielToLernziele(Lernziel lernziel) throws Exception {
		if (lernziele.contains(lernziel)) {
			throw new Exception("Lernziel ist bereits enthalten!");
		} else {
			lernziele.add(lernziel);
		}
	}

	public void removeLernzielFromLernziele(Lernziel lernziel) throws Exception {
		if (!lernziele.contains(lernziel)) {
			throw new Exception("Lernziel ist nicht vorhanden!");
		} else {
			lernziele.remove(lernziel);
		}
	}

	public Lernziel getLernziel() {
		return lernziel;
	}

	public void setLernziel(Lernziel lernziel) {
		this.lernziel = lernziel;
	}

}
