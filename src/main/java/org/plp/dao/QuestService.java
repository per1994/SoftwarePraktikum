package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Quest;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestService {

	@Autowired
	private QuestDAO questDAO;

	@Transactional
	public void addNewQuest(String questName) {
		System.out.println("Ich bin im Service, Methode addNewQuest");
		Quest quest = new Quest();
		questDAO.add(quest);

	}

	@Transactional
	public List<Quest> listAllQuests() {
		return questDAO.listQuests();
	}

	@Transactional
	public void löschen(int quest_id) {
		questDAO.löschen(quest_id);
	}

	@Transactional
	public void update(int quest_id) {
		questDAO.update(quest_id);
	}

	@Transactional
	public Quest getQuest(int quest_id) {
		return questDAO.getQuest(quest_id);
	}
}
