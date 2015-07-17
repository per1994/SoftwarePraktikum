package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementService {

	@Autowired
	private AchievementDAO achievementDAO;

	@Transactional
	public void addNewAchievement() {

		Achievement b = new Achievement();
		achievementDAO.add(b);

	}

	@Transactional
	public List<Achievement> listAllAchievement() {
		return achievementDAO.listAchievement();
	}

	@Transactional
	public void löschen(int achievement_id) {
		achievementDAO.löschen(achievement_id);
	}

	@Transactional
	public void update(Achievement achievement) {
		achievementDAO.update(achievement);
	}

	@Transactional
	public Achievement getAchievement(int achievement_id) {
		return achievementDAO.getAchievement(achievement_id);
	}

	@Transactional
	public boolean vorhanden(int achievement_id) {
		return achievementDAO.vorhanden(achievement_id);
	}
}
