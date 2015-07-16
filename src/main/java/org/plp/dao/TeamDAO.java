package org.plp.dao;

import java.util.List;

import org.plp.gamification.Team;

public interface TeamDAO {

	public void add(Team team);

	public List<Team> listTeams();

	public void löschen(int team_id);

	public boolean update(int team_id);

	public Team getTeam(int team_id);

}
