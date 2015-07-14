package org.plp.gamification;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.plp.benutzer.Benutzer;

@Entity
@Table(name = "COMBAT")
public class Combat {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	private HashSet<Benutzer> teilnehmer = new HashSet<Benutzer>();

	private Aufgabe aufgabe;

	private Benutzer gewinner;

	private Benutzer verlierer;

	@Column(name = "punkteGewinner")
	private int punkteGewinner;

	@Column(name = "punkteVerlierer")
	private int punkteVerlierer;

	@Column(name = "punkteUnentschieden")
	private int punkteUnentschieden;

	private boolean unentschieden;

	// Hier kommt der Konstruktor hin
	public Combat(Benutzer teilnehmer1, Benutzer teilnehmer2) {
		teilnehmer.add(teilnehmer1);
		teilnehmer.add(teilnehmer2);
	}

	public void updateBenutzerZahlen() {
		if (!unentschieden) {
			gewinner.SetPunktzahl(gewinner.getPunktzahl() + punkteGewinner);
			gewinner.setAnzahlSiege(gewinner.getAnzahlSiege() + 1);
			verlierer.SetPunktzahl(verlierer.getPunktzahl() + punkteVerlierer);
			verlierer
					.setAnzahlNiederlagen(verlierer.getAnzahlNiederlagen() + 1);
		} else {
			for (Benutzer b : teilnehmer) {
				b.SetPunktzahl(b.getPunktzahl() + punkteUnentschieden);
				b.setAnzahlUnentschieden(b.getAnzahlUnentschieden() + 1);
			}
		}
		for (Benutzer b : teilnehmer) {
			b.setAnzahlCombats(b.getAnzahlCombats() + 1);
		}
	}

	public HashSet<Benutzer> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(HashSet<Benutzer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public Aufgabe getAufgabe() {
		return aufgabe;
	}

	public void setAufgabe(Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
	}

	public Benutzer getGewinner() {
		return gewinner;
	}

	public void setGewinner(Benutzer gewinner) {
		this.gewinner = gewinner;
	}

	public Benutzer getVerlierer() {
		return verlierer;
	}

	public void setVerlierer(Benutzer verlierer) {
		this.verlierer = verlierer;
	}

	public int getPunkteGewinner() {
		return punkteGewinner;
	}

	public void setPunkteGewinner(int punkteGewinner) {
		this.punkteGewinner = punkteGewinner;
	}

	public int getPunkteVerlierer() {
		return punkteVerlierer;
	}

	public void setPunkteVerlierer(int punkteVerlierer) {
		this.punkteVerlierer = punkteVerlierer;
	}

	public int getPunkteUnentschieden() {
		return punkteUnentschieden;
	}

	public void setPunkteUnentschieden(int punkteUnentschieden) {
		this.punkteUnentschieden = punkteUnentschieden;
	}

	public boolean isUnentschieden() {
		return unentschieden;
	}

	public void setUnentschieden(boolean unentschieden) {
		this.unentschieden = unentschieden;
	}

}
