package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Combat;
import org.springframework.beans.factory.annotation.Autowired;

public class CombatService {

	@Autowired
	private CombatDAO combatDAO;

	@Transactional
	public void addNewCombat(String combatName) {
		System.out.println("Ich bin im Service, Methode addNewCombat");
		Combat combat = new Combat();
		combatDAO.add(combat);

	}

	@Transactional
	public List<Combat> listAllCombats() {
		return combatDAO.listCombats();
	}

	@Transactional
	public void löschen(int combat_id) {
		combatDAO.löschen(combat_id);
	}

	@Transactional
	public void update(int combat_id) {
		combatDAO.update(combat_id);
	}

	@Transactional
	public Combat getCombat(int combat_id) {
		return combatDAO.getCombat(combat_id);
	}
}
