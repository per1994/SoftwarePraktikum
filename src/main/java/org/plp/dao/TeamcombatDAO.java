package org.plp.dao;

import java.util.List;

import org.plp.gamification.Teamcombat;

public interface TeamcombatDAO {
	public void add(Teamcombat teamcombat);

	public List<Teamcombat> listTeamcombat();

	public void löschen(int teamcombat_id);

	public void update(Teamcombat teamcombat);

	public Teamcombat getTeamcombat(int teamcombat_id);

	public boolean vorhanden(int teamcombat_id);

}
