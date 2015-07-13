package org.plp.grundfunktionen;

import java.util.Date;

import org.plp.benutzer.Benutzer;
import org.plp.gamification.Combat;
import org.plp.gruppenfunktionen.Gruppe;

public class Nachricht {

	private Object sender;
	private Object empf�nger;
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
	public static final int FREUNDSCHAFTSANFRAGEANGENOMMEN = 4;
	public static final int GRUPPENEINLADUNGANGENOMMEN = 5;
	public static final int COMBATANFRAGEANGENOMMEN = 6;
	public static final int TEAMCOMBATANFRAGEANGENOMMEN = 7;
	public static final int PINNWANDEINTRAGERHALTEN = 8;
	
	public Nachricht(Object sender, Object empf�nger, int typ, Object anhang) {
		switch (typ) {
		case (0):
			titel = "Freundschaftsanfrage";
			inhalt = ((Benutzer) sender).getVorname() + " "
					+ ((Benutzer) sender).getNachname()
					+ " m�chte mit dir befreundet sein!";
			break;
		case (1):
			titel = "Gruppeneinladung";
			inhalt = "Du wurdest in die Gruppe " + ((Gruppe) sender).getName()
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
		case (3):
			titel = "Team-Combat-Herausforderung";
			inhalt = "Die Gruppe " + ((Gruppe) sender).getName()
					+ " hat euch zu einem Team-Combat in der Fachrichtung "
					+ ((Combat) anhang).getAufgabe().getFachrichtung()
					+ " herausgefordert";
			break;
		case (4):
			titel = "Freundschaftsanfrage angenommen";
			inhalt = ((Benutzer) sender).getVorname() + " "
					+ ((Benutzer) sender).getNachname()
					+ " hat deine Freundschaftsanfrage akzeptiert!";
			break;
		case (5):
			titel = "Neues Gruppenmitglied";
			inhalt = ((Benutzer) sender).getVorname() + " "
					+ ((Benutzer) sender).getNachname() + " ist deiner Gruppe "
					+ ((Gruppe) empf�nger).getName() + " beigetreten!";
			break;
		case (6):
			titel = "Combat-Herausforderung angenommen";
			inhalt = ((Benutzer) sender).getVorname() + " "
					+ ((Benutzer) sender).getNachname()
					+ " hat deine Herausforderung zum Combat angenommen!";
			break;
		case (7):
			titel = "Team-Combat-Herausforderung angenommen";
			inhalt = ((Gruppe) sender).getName()
					+ " hat deine Herausforderung zum Team-Combat angenommen!";
			break;
		case (8):
			titel = "Pinnwandeintrag erhalten";
			inhalt = ((Benutzer) anhang).getVorname() + " "
					+ ((Benutzer) anhang).getNachname()
					+ " hat einen Eintrag auf deiner Pinnwand hinterlassen";
			break;
		}
		this.sender = sender;
		this.empf�nger = empf�nger;
		this.typ = typ;
		this.anhang = anhang;
		datum = new Date();
	}

	public Object getSender() {
		return sender;
	}

	public void setSender(Benutzer sender) {
		this.sender = sender;
	}

	public Object getEmpf�nger() {
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
