package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Teamcombat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamcombatService {

	@Autowired
	private TeamcombatDAO teamcombatDAO;

	@Transactional
	public void addNewTeamcombat() {

		Teamcombat b = new Teamcombat();
		teamcombatDAO.add(b);

	}

	@Transactional
	public List<Teamcombat> listAllTeamcombat() {
		return teamcombatDAO.listTeamcombat();
	}

	@Transactional
	public void löschen(int teamcombat_id) {
		teamcombatDAO.löschen(teamcombat_id);
	}

	@Transactional
	public void update(Teamcombat teamcombat) {
		teamcombatDAO.update(teamcombat);
	}

	@Transactional
	public Teamcombat getTeamcombat(int teamcombat_id) {
		return teamcombatDAO.getTeamcombat(teamcombat_id);
	}

	@Transactional
	public boolean vorhanden(int teamcombat_id) {
		return teamcombatDAO.vorhanden(teamcombat_id);
	}
}
