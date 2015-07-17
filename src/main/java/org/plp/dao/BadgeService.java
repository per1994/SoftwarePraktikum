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
	public void addNewBadge() {

		Badge b = new Badge();
		badgeDAO.add(b);

	}

	@Transactional
	public List<Badge> listAllBadge() {
		return badgeDAO.listBadge();
	}

	@Transactional
	public void löschen(int badge_id) {
		badgeDAO.löschen(badge_id);
	}

	@Transactional
	public void update(Badge badge) {
		badgeDAO.update(badge);
	}

	@Transactional
	public Badge getBadge(int badge_id) {
		return badgeDAO.getBadge(badge_id);
	}

	@Transactional
	public boolean vorhanden(int badge_id) {
		return badgeDAO.vorhanden(badge_id);
	}
}
