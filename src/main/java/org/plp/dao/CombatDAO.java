package org.plp.dao;

import java.util.List;

import org.plp.gamification.Combat;

public interface CombatDAO {
	public void add(Combat combat);

	public List<Combat> listCombat();

	public void löschen(int combat_id);

	public void update(Combat combat);

	public Combat getCombat(int combat_id);

	public boolean vorhanden(int combat_id);

}
