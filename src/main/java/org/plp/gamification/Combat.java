package org.plp.gamification;

import java.util.HashSet;

import org.plp.benutzer.Benutzer;

public class Combat {

	private HashSet<Benutzer> teilnehmer = new HashSet<Benutzer>();
	private Aufgabe aufgabe;
	private Benutzer gewinner;
	private Benutzer verlierer;
	private int punkteGewinner;
	private int punkteVerlierer;
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

	public void setPunkteGewinner(int punktzahlGewinner) {
		punkteGewinner = punktzahlGewinner;
	}

	public void setPunkteVerlierer(int punktzahlVerlierer) {
		punkteVerlierer = punktzahlVerlierer;
	}

	public void setPunktUnentschieden(int punktzahl) {
		punkteUnentschieden = punktzahl;
	}

	public void setGewinner(Benutzer gewinner) {
		this.gewinner = gewinner;
	}

	public void setVerlierer(Benutzer verlierer) {
		this.verlierer = verlierer;
	}

}
