package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

	@Autowired
	private TeamDAO teamDAO;

	@Transactional
	public void addNewTeam() {

		Team b = new Team();
		teamDAO.add(b);

	}

	@Transactional
	public List<Team> listAllTeam() {
		return teamDAO.listTeam();
	}

	@Transactional
	public void löschen(int team_id) {
		teamDAO.löschen(team_id);
	}

	@Transactional
	public void update(Team team) {
		teamDAO.update(team);
	}

	@Transactional
	public Team getTeam(int team_id) {
		return teamDAO.getTeam(team_id);
	}

	@Transactional
	public boolean vorhanden(int team_id) {
		return teamDAO.vorhanden(team_id);
	}
}
