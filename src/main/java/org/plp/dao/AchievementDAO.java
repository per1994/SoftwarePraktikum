package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Achievement;
import org.plp.benutzer.Benutzer;

public interface AchievementDAO {
	
	public void add(Achievement achievement);
	public List<Achievement> listAchievements();
	public void löschen(int achievement_id);
	public boolean update(int achievement_id);
	public Achievement getAchievement(int achievement_id);

}
