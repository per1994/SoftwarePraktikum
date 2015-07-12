package org.plp.grundfunktionen;

import java.util.Date;

import org.plp.benutzer.Benutzer;
import org.plp.gamification.Combat;
import org.plp.gruppenfunktionen.Gruppe;

public class Nachricht {

	private Benutzer sender;
	private Benutzer empf�nger;
	private boolean statisch;
	private int typ;
	private Date datum;
	private String titel;
	private String inhalt;
	private Object anhang;

	public static final int FREUNDSCHAFTSANRAGE = 0;
	public static final int GRUPPENEINLADUNG = 1;
	public static final int COMBATANFRAGE = 2;
	public static final int TEAMCOMBATANFRAGE = 3;

	public Nachricht(Benutzer sender, Benutzer empf�nger, int typ, Object anhang) {
		switch (typ) {
		case (0):
			titel = "Freundschaftsanfrage";
			inhalt = ((Benutzer) sender).getVorname() + " "
					+ ((Benutzer) sender).getNachname()
					+ " m�chte mit dir befreundet sein!";
			break;
		case (1):
			titel = "Gruppeneinladung";
			inhalt = ((Benutzer) sender).getVorname() + " "
					+ ((Benutzer) sender).getNachname()
					+ " hat dich in die Gruppe " + ((Gruppe) anhang).getName()
					+ " eingeladen";
			break;
		case (2):
			titel = "Combat-Herausforderung";
			inhalt = ((Benutzer) sender).getVorname() + " "
					+ ((Benutzer) sender).getNachname()
					+ " hat dich zu einem Combat im Themengebiet "
					+ ((Combat) anhang).getAufgabe().getThemengebiet()
					+ " heraufgefordert!";
			break;
		}
		this.sender = sender;
		this.empf�nger = empf�nger;
		this.typ = typ;
		this.anhang = anhang;
		datum = new Date();
	}

	public Benutzer getSender() {
		return sender;
	}

	public void setSender(Benutzer sender) {
		this.sender = sender;
	}

	public Benutzer getEmpf�nger() {
		return empf�nger;
	}

	public void setEmpf�nger(Benutzer empf�nger) {
		this.empf�nger = empf�nger;
	}

	public boolean isStatisch() {
		return statisch;
	}

	public void setStatisch(boolean statisch) {
		this.statisch = statisch;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public Object getAnhang() {
		return anhang;
	}

	public void setAnhang(Object anhang) {
		this.anhang = anhang;
	}

}
