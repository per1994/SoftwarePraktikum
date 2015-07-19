package org.plp.grundfunktionen;

import org.plp.benutzer.Benutzer;
import org.plp.dao.AchievementService;
import org.plp.dao.BadgeService;
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

	@Autowired
	BadgeService badgeservice;

	@Autowired
	AchievementService achievementservice;

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
			int anhang, boolean bearbeitet, boolean statisch) {
		Nachricht gruppenEinladung = new Nachricht(sender, empfänger, anhang,
				bearbeitet, statisch, 1);
		gruppenEinladung.setInhalt(benutzerservice.getBenutzer(sender)
				.getVorname()
				+ " "
				+ "hat dich in die Gruppe"
				+ " "
				+ gruppenservice.getGruppe(anhang).getGruppenName()
				+ " "
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
				+ "will dich zu einem Combat im Themengebiet"
				+ " "
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

	public Nachricht neueBadgeErhaltenErstellen(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch) {

		Nachricht neueBadgeErhalten = new Nachricht(sender, empfänger, anhang,
				bearbeitet, statisch, 9);
		neueBadgeErhalten.setInhalt("Glückwunsch! Du hast "
				+ badgeservice.getBadge(anhang).getBenötigtePunkte()
				+ "gesammelt. Deiner neuer Rang lautet "
				+ badgeservice.getBadge(anhang).getName());
		nachrichtservice.addNewNachricht(neueBadgeErhalten);
		return neueBadgeErhalten;
	}

	public Nachricht neuesAchievementErhaltenErstellen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {

		Nachricht neuesAchievementErhalten = new Nachricht(sender, empfänger,
				anhang, bearbeitet, statisch, 10);
		neuesAchievementErhalten
				.setInhalt("Glückwünsch! Du hast das Achievement "
						+ achievementservice.getAchievement(anhang).getName()
						+ " erhalten. Dir werden "
						+ achievementservice.getAchievement(anhang)
								.getPunkteWert() + " Punkte gutgeschrieben.");
		nachrichtservice.addNewNachricht(neuesAchievementErhalten);
		return neuesAchievementErhalten;
	}

	public Nachricht combatErgebnisBenachrichtungErstellen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {

		Benutzer benutzer = combatservice.getCombat(anhang).getTeilnehmer()
				.iterator().next();

		Nachricht combatErgebnisBenachrichtigung = new Nachricht(sender,
				empfänger, anhang, bearbeitet, statisch, 11);
		if (combatservice.getCombat(anhang).isUnentschieden()) {
			if (benutzer.getBenutzer_id() == empfänger) {
				benutzer = combatservice.getCombat(anhang).getTeilnehmer()
						.iterator().next();
			}
			combatErgebnisBenachrichtigung.setInhalt("Dein Combat gegen "
					+ benutzer.getBenutzerName()
					+ " im Themengebiet "
					+ combatservice.getCombat(anhang).getAufgabe()
							.getThemengebiet()
					+ " hat keinen Sieger hevorgebracht! Dir werden "
					+ combatservice.getCombat(anhang).getPunkteUnentschieden()
					+ " gutgeschrieben");
		}

		if (empfänger == combatservice.getCombat(anhang).getGewinner()
				.getBenutzer_id()) {
			combatErgebnisBenachrichtigung.setInhalt("Du hast da Combat gegen "
					+ combatservice.getCombat(anhang).getVerlierer()
							.getBenutzerName()
					+ " im Themengebiet "
					+ combatservice.getCombat(anhang).getAufgabe()
							.getThemengebiet() + " gewonnen! Dir werden "
					+ combatservice.getCombat(anhang).getPunkteGewinner()
					+ " Punkte gutgeschrieben.");
		}
		if (empfänger == combatservice.getCombat(anhang).getGewinner()
				.getBenutzer_id()) {
			combatErgebnisBenachrichtigung.setInhalt("Du hast da Combat gegen "
					+ combatservice.getCombat(anhang).getVerlierer()
							.getBenutzerName()
					+ " im Themengebiet "
					+ combatservice.getCombat(anhang).getAufgabe()
							.getThemengebiet() + " gewonnen! Dir werden "
					+ combatservice.getCombat(anhang).getPunkteGewinner()
					+ " Punkte gutgeschrieben.");
		}
		return combatErgebnisBenachrichtigung;
	}
}
