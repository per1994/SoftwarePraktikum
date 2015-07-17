package org.plp.dao;

import java.util.List;

import org.plp.gamification.Team;

public interface TeamDAO {
	public void add(Team team);

	public List<Team> listTeam();

	public void löschen(int team_id);

	public void update(Team team);

	public Team getTeam(int team_id);

	public boolean vorhanden(int team_id);

}
