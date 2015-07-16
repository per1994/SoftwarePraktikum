package org.plp.dao;

import java.util.List;

import org.plp.gamification.Combat;

public interface CombatDAO {

	public void add(Combat combat);

	public List<Combat> listCombats();

	public void löschen(int combat_id);

	public boolean update(int combat_id);

	public Combat getCombat(int combat_id);

}
