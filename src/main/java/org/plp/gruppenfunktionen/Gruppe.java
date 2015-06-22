package org.plp.gruppenfunktionen;

import org.plp.benutzer.*;
import org.plp.gamification.*;
import java.util.ArrayList;

public class Gruppe {

	private ArrayList<Benutzer> mitgliederListe = new ArrayList<Benutzer> ();
	private ArrayList<Moderator> moderatorenListe = new ArrayList<Moderator> ();
	private int anzahlMitglieder = 0;
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
	
	public void addMitgliedToMitgliederListe(Benutzer benutzer) {
		mitgliederListe.add(benutzer);
	}
	
	public ArrayList<Moderator> getModeratorenListe() {
		return moderatorenListe;
	}
	
	public void addModeratorToModeratorenListe(Moderator moderator) {
		moderatorenListe.add(moderator);
	}
	
	public int getAnzahlMitglieder() {
		return anzahlMitglieder;
	}
	
	public void setAnzahlMitglieder(int anzahlMitglieder) {
		this.anzahlMitglieder = anzahlMitglieder;
		Moderator auch in MitgliederListe? sonst Länge + Länge
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
	
	public void addLernzielToLernziele(Lernziel lernziel) {
		lernziele.add(lernziel);
	}
	
	public Lernziel getLernziel() {
		return lernziel;
	}
	
	public void setLernziel(Lernziel lernziel) {
		this.lernziel = lernziel;
	}
	
	
	
}
