package org.plp.grundfunktionen;

import org.plp.dao.BenutzerService;
import org.plp.dao.CombatService;
import org.plp.dao.GruppeService;
import org.plp.dao.NachrichtService;
import org.plp.dao.TeamcombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class Nachrichtengenerator {

	@Autowired
	BenutzerService benutzerservice;

	@Autowired
	NachrichtService nachrichtservice;

	@Autowired
	CombatService combatservice;

	@Autowired
	TeamcombatService teamcombatservice;

	@Autowired
	GruppeService gruppenservice;

	public Nachricht freundschaftsanfrageErstellen(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch) {

		Nachricht freundschaftsAnfrage = new Nachricht(sender, empfänger,
				anhang, false, false, 0);
		freundschaftsAnfrage.setInhalt(benutzerservice.getBenutzer(sender)
				.getVorname()
				+ " "
				+ benutzerservice.getBenutzer(sender).getNachname()
				+ " möchte mit dir befreundet sein!");
		nachrichtservice.addNewNachricht(freundschaftsAnfrage);

		return freundschaftsAnfrage;

	}

	public Nachricht gruppeneinladungErstellen(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch, int nachrichtenTyp) {
		Nachricht gruppenEinladung = new Nachricht(sender, empfänger, anhang,
				bearbeitet, statisch, 1);
		gruppenEinladung.setInhalt(benutzerservice.getBenutzer(sender)
				.getVorname()
				+ " "
				+ "hat dich in die Gruppe"
				+ ""
				+ gruppenservice.getGruppe(anhang).getGruppenName()
				+ "eingeladen");
		nachrichtservice.addNewNachricht(gruppenEinladung);
		return gruppenEinladung;
	}

	public Nachricht combatanfrageErstellen(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch) {
		Nachricht combatAnfrage = new Nachricht(sender, empfänger, anhang,
				bearbeitet, statisch, 2);
		combatAnfrage.setInhalt(benutzerservice.getBenutzer(sender)
				.getVorname()
				+ " "
				+ "will dich zu einem Combat im Fachgebiet"
				+ ""
				+ combatservice.getCombat(anhang).getAufgabe()
						.getThemengebiet() + " herausfordern");
		nachrichtservice.addNewNachricht(combatAnfrage);
		return combatAnfrage;
	}

	public Nachricht teamcombatanfrageErstellen(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch) {
		Nachricht teamcombatAnfrage = new Nachricht(sender, empfänger, anhang,
				bearbeitet, statisch, 3);
		teamcombatAnfrage.setInhalt("Die Gruppe" + ""
				+ gruppenservice.getGruppe(sender).getGruppenName()
				+ "möchte dich zu einem Teamcombat mit dem Fachgebiet" + ""
				+ gruppenservice.getGruppe(sender).getFachrichtung().getName()
				+ "" + "herausfordern");
		nachrichtservice.addNewNachricht(teamcombatAnfrage);
		return teamcombatAnfrage;
	}

	public Nachricht freundschaftsanfrageAngenommenErstllen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {

		Nachricht freundschaftsAnfrageAngenommen = new Nachricht(sender,
				empfänger, anhang, bearbeitet, statisch, 4);
		freundschaftsAnfrageAngenommen.setInhalt(benutzerservice.getBenutzer(
				sender).getBenutzerName()
				+ " hat deine Freundschaftsanfrage angenommen");

		nachrichtservice.addNewNachricht(freundschaftsAnfrageAngenommen);
		return freundschaftsAnfrageAngenommen;

	}

	public Nachricht gruppenEinladungAngenommenErstellen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {
		Nachricht gruppenEinladungAngenommen = new Nachricht(sender, empfänger,
				anhang, bearbeitet, statisch, 5);
		gruppenEinladungAngenommen.setInhalt(benutzerservice
				.getBenutzer(sender).getBenutzerName()
				+ " ist deiner Gruppe "
				+ gruppenservice.getGruppe(anhang).getGruppenName()
				+ " beigetreten!");
		nachrichtservice.addNewNachricht(gruppenEinladungAngenommen);
		return gruppenEinladungAngenommen;
	}

	public Nachricht combatanfrageAngenommenErstellen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {

		Nachricht combatAnfrageAngenommen = new Nachricht(sender, empfänger,
				anhang, bearbeitet, statisch, 6);
		combatAnfrageAngenommen.setInhalt(benutzerservice.getBenutzer(sender)
				.getBenutzerName()
				+ " hat deine Herausforderung zum Combat angenommen");
		nachrichtservice.addNewNachricht(combatAnfrageAngenommen);
		return combatAnfrageAngenommen;

	}

	public Nachricht teamCombatAnfrageAngenommenErstellen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {

		Nachricht teamCombatAnfrageAngenommen = new Nachricht(sender,
				empfänger, anhang, bearbeitet, statisch, 7);
		teamCombatAnfrageAngenommen.setInhalt(gruppenservice.getGruppe(sender)
				.getGruppenName()
				+ " hat deine Herausforderung zum Team-Combat angenommen");
		nachrichtservice.addNewNachricht(teamCombatAnfrageAngenommen);
		return teamCombatAnfrageAngenommen;

	}

	public Nachricht pinnwandEintragErhaltenErstellen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {

		Nachricht pinnwandEintragErhalten = new Nachricht(sender, empfänger,
				anhang, bearbeitet, statisch, 8);
		pinnwandEintragErhalten.setInhalt(benutzerservice.getBenutzer(sender)
				.getVorname()
				+ " "
				+ benutzerservice.getBenutzer(sender).getNachname()
				+ " hat einen Eintrag auf deiner Pinnwand hinterlassen!");

		nachrichtservice.addNewNachricht(pinnwandEintragErhalten);
		return pinnwandEintragErhalten;

	}
}
