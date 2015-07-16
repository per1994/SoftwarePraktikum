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
	public void addNewAchievement(String achievementName){
		System.out.println("Ich bin im Service, Methode addNewAchievement");
		Achievement achievement=new Achievement();
		achievementDAO.add(achievement);
		
	}
	
	@Transactional
	public List<Achievement>listAllAchievement(){
		return achievementDAO.listAchievements();
	}
	
	@Transactional
	public void löschen(int achievement_id){
		achievementDAO.löschen(achievement_id);
	}
	
	@Transactional
	public void update( int achievement_id){
		achievementDAO.update(achievement_id);
	}

	@Transactional
	public Achievement getAchievement(int achievement_id){
		return achievementDAO.getAchievement(achievement_id);
	}
}
