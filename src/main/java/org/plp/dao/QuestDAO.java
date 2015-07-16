package org.plp.dao;

import java.util.List;

import org.plp.gamification.Quest;

public interface QuestDAO {

	public void add(Quest quest);

	public List<Quest> listQuests();

	public void l�schen(int quest_id);

	public boolean update(int quest_id);

	public Quest getQuest(int quest_id);

}
