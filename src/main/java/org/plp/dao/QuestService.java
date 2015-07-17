package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

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
}
