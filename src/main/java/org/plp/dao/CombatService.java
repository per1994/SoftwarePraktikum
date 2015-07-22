package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Benutzer;
import org.plp.gamification.Combat;
import org.plp.gamification.Teilaufgabe;
import org.plp.grundfunktionen.Nachrichtengenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombatService {

	@Autowired
	private CombatDAO combatDAO;

	@Autowired
	private Nachrichtengenerator nachrichtengenerator;

	@Autowired
	private BenutzerService benutzerservice;

	@Autowired
	private BadgeService badgeservice;

	@Transactional
	public void addNewCombat(Combat b) {

		combatDAO.add(b);

	}

	@Transactional
	public List<Combat> listAllCombat() {
		return combatDAO.listCombat();
	}

	@Transactional
	public void löschen(int combat_id) {
		combatDAO.löschen(combat_id);
	}

	@Transactional
	public void update(Combat combat) {
		combatDAO.update(combat);
	}

	@Transactional
	public Combat getCombat(int combat_id) {
		return combatDAO.getCombat(combat_id);
	}

	@Transactional
	public boolean vorhanden(int combat_id) {
		return combatDAO.vorhanden(combat_id);
	}

	@Transactional
	public void combatAuswerten(int combat, int aktiverBenutzer) {

		for (Teilaufgabe teilaufgabe : this.getCombat(combat).getAufgabe()
				.getTeilAufgaben()) {
			teilaufgabe.teilaufgabeKorrigieren();
		}
		this.getCombat(combat).getAufgabe().korrigiere();

		// Prüft ob bereits eine Lösung eingereicht wurde
		if (!this.getCombat(combat).isEineLösungEingereicht()) {
			this.getCombat(combat).setPunkteErsteAbgabe(
					this.getCombat(combat).getAufgabe().getPunktzahl());
			this.getCombat(combat).setEineLösungEingereicht(true);
			this.getCombat(combat).setErsterBenutzer_id(aktiverBenutzer);
		} else {

			// Erhöht bei beiden Teilnehmern die Anzahl der bestrittenen
			// Combats um 1
			for (Benutzer b : this.getCombat(combat).getTeilnehmer()) {
				b.setAnzahlCombats(b.getAnzahlCombats() + 1);

				// Combat endet unentschieden
				if (this.getCombat(combat).getPunkteErsteAbgabe() == this
						.getCombat(combat).getAufgabe().getPunktzahl()) {
					this.getCombat(combat).setUnentschieden(true);
					this.getCombat(combat).setPunkteUnentschieden(
							this.getCombat(combat).getPunkteErsteAbgabe());
					for (Benutzer teilnehmer : this.getCombat(combat)
							.getTeilnehmer()) {
						teilnehmer.setPunktzahl(teilnehmer.getPunktzahl()
								+ this.getCombat(combat)
										.getPunkteUnentschieden());

						teilnehmer.setAnzahlUnentschieden(teilnehmer
								.getAnzahlUnentschieden() + 1);
						nachrichtengenerator
								.combatErgebnisBenachrichtungErstellen(combat,
										teilnehmer.getBenutzer_id(), combat,
										false, true);
						benutzerservice.aufBadgeÜberprüfen(teilnehmer
								.getBenutzer_id());

					}
				} else if (this.getCombat(combat).getPunkteErsteAbgabe() > this
						.getCombat(combat).getAufgabe().getPunktzahl()) {
					this.getCombat(combat).setPunkteGewinner(
							this.getCombat(combat).getPunkteErsteAbgabe());
					this.getCombat(combat).setPunkteVerlierer(
							this.getCombat(combat).getAufgabe().getPunktzahl());
					this.getCombat(combat).setGewinner(
							benutzerservice.getBenutzer(this.getCombat(combat)
									.getErsterBenutzer_id()));
					this.getCombat(combat).setVerlierer(
							benutzerservice.getBenutzer(aktiverBenutzer));
					this.getCombat(combat)
							.updateBenutzerZahlenKeinUnentschieden();
					for (Benutzer benutzer : this.getCombat(combat)
							.getTeilnehmer()) {
						nachrichtengenerator
								.combatErgebnisBenachrichtungErstellen(combat,
										benutzer.getBenutzer_id(), combat,
										false, true);
						benutzerservice.aufBadgeÜberprüfen(benutzer
								.getBenutzer_id());

					}

				} else {
					this.getCombat(combat).setPunkteVerlierer(
							this.getCombat(combat).getPunkteErsteAbgabe());
					this.getCombat(combat).setPunkteGewinner(
							this.getCombat(combat).getAufgabe().getPunktzahl());
					this.getCombat(combat).setVerlierer(
							benutzerservice.getBenutzer(this.getCombat(combat)
									.getErsterBenutzer_id()));
					this.getCombat(combat).setGewinner(
							benutzerservice.getBenutzer(aktiverBenutzer));
					this.getCombat(combat)
							.updateBenutzerZahlenKeinUnentschieden();
					for (Benutzer benutzer : this.getCombat(combat)
							.getTeilnehmer()) {
						nachrichtengenerator
								.combatErgebnisBenachrichtungErstellen(combat,
										benutzer.getBenutzer_id(), combat,
										false, true);
						benutzerservice.aufBadgeÜberprüfen(benutzer
								.getBenutzer_id());
					}

				}
			}
		}
	}
}
