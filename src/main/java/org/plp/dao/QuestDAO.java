package org.plp.dao;

import java.util.List;

import org.plp.gamification.Quest;

public interface QuestDAO {
	public void add(Quest quest);

	public List<Quest> listQuest();

	public void löschen(int quest_id);

	public void update(Quest quest);

	public Quest getQuest(int quest_id);

	public boolean vorhanden(int quest_id);

}
