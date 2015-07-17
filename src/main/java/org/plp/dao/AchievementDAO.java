package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Achievement;

public interface AchievementDAO {
	public void add(Achievement achievement);

	public List<Achievement> listAchievement();

	public void löschen(int achievement_id);

	public void update(Achievement achievement);

	public Achievement getAchievement(int achievement_id);

	public boolean vorhanden(int achievement_id);

}
