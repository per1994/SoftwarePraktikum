package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BadgeService {
	
	@Autowired
	private BadgeDAO badgeDAO;
	
	@Transactional
	public void addNewBadge(String badgeName){
		System.out.println("Ich bin im Service, Methode addNewBadge");
		Badge badge=new Badge();
		badgeDAO.add(badge);
		
	}
	
	@Transactional
	public List<Badge>listAllBadge(){
		return badgeDAO.listBadges();
	}
	
	@Transactional
	public void löschen(int badge_id){
		badgeDAO.löschen(badge_id);
	}
	
	@Transactional
	public void update( int badge_id){
		badgeDAO.update(badge_id);
	}

	@Transactional
	public Badge getBadge(int badge_id){
		return badgeDAO.getBadge(badge_id);
	}
}
