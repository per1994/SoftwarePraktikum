package org.plp.gruppenfunktionen;

import org.plp.benutzer.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Gruppe {

	@Id
	@Column(name = "gruppe_id")
	@GeneratedValue
	private int gruppe_id;

	private Set<Benutzer> mitgliederListe;

	private Set<Benutzer> moderatorenListe;

	private int anzahlMitglieder;

	private Fachrichtung fachrichtung;

	private double lernfortschritt;

	private String gruppenName;

	private Set<String> lernziele;

	public Gruppe() {
		mitgliederListe = new HashSet<Benutzer>();
		moderatorenListe = new HashSet<Benutzer>();
		lernziele = new HashSet<String>();
	}

	public int getGruppe_id() {
		return gruppe_id;
	}

	public void setGruppe_id(int gruppe_id) {
		this.gruppe_id = gruppe_id;
	}

	public Set<Benutzer> getMitgliederListe() {
		return mitgliederListe;
	}

	public void setMitgliederListe(Set<Benutzer> mitgliederListe) {
		this.mitgliederListe = mitgliederListe;
	}

	public Set<Benutzer> getModeratorenListe() {
		return moderatorenListe;
	}

	public void setModeratorenListe(Set<Benutzer> moderatorenListe) {
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

	public double getLernfortschritt() {
		return lernfortschritt;
	}

	public void setLernfortschritt(double lernfortschritt) {
		this.lernfortschritt = lernfortschritt;
	}

	public String getGruppenName() {
		return gruppenName;
	}

	public void setGruppenName(String gruppenName) {
		this.gruppenName = gruppenName;
	}

	public Set<String> getLernziele() {
		return lernziele;
	}

	public void setLernziele(Set<String> lernziele) {
		this.lernziele = lernziele;
	}

}
