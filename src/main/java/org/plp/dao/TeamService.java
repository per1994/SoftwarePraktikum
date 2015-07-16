package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Team;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamService {

	@Autowired
	private TeamDAO teamDAO;

	@Transactional
	public void addNewTeam(String teamName) {
		System.out.println("Ich bin im Service, Methode addNewTeam");
		Team team = new Team();
		teamDAO.add(team);

	}

	@Transactional
	public List<Team> listAllTeams() {
		return teamDAO.listTeams();
	}

	@Transactional
	public void löschen(int team_id) {
		teamDAO.löschen(team_id);
	}

	@Transactional
	public void update(int team_id) {
		teamDAO.update(team_id);
	}

	@Transactional
	public Team getTeam(int team_id) {
		return teamDAO.getTeam(team_id);
	}
}
