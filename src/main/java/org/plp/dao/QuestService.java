package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Benutzer;
import org.plp.gamification.Quest;
import org.plp.gamification.Teilaufgabe;
import org.plp.grundfunktionen.Nachrichtengenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

	@Autowired
	private BenutzerService benutzerservice;

	@Autowired
	private Nachrichtengenerator nachrichtengenerator;

	@Autowired
	private QuestDAO questDAO;

	@Transactional
	public void addNewQuest() {

		Quest b = new Quest();
		questDAO.add(b);

	}

	@Transactional
	public List<Quest> listAllQuest() {
		return questDAO.listQuest();
	}

	@Transactional
	public void löschen(int quest_id) {
		questDAO.löschen(quest_id);
	}

	@Transactional
	public void update(Quest quest) {
		questDAO.update(quest);
	}

	@Transactional
	public Quest getQuest(int quest_id) {
		return questDAO.getQuest(quest_id);
	}

	@Transactional
	public boolean vorhanden(int quest_id) {
		return questDAO.vorhanden(quest_id);
	}

	@Transactional
	public void questAuswerten(int quest, int aktiverBenutzer) {
		for (Teilaufgabe teilaufgabe : this.getQuest(quest).getAufgabe()
				.getTeilAufgaben()) {
			teilaufgabe.teilaufgabeKorrigieren();

		}
		this.getQuest(quest).getAufgabe().korrigiere();
		benutzerservice.getBenutzer(aktiverBenutzer)
				.setAnzahlQuest(
						benutzerservice.getBenutzer(aktiverBenutzer)
								.getAnzahlQuest() + 1);
		benutzerservice.getBenutzer(aktiverBenutzer).setPunktzahl(
				benutzerservice.getBenutzer(aktiverBenutzer).getPunktzahl()
						+ this.getQuest(quest).getAufgabe().getPunktzahl());
		nachrichtengenerator.questErgebnisBenachrichtungErstellen(quest,
				aktiverBenutzer, quest, false, true);
		benutzerservice.aufBadgeÜberprüfen(aktiverBenutzer);

	}
}
