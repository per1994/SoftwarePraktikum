package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Combat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombatService {

	@Autowired
	private CombatDAO combatDAO;

	@Transactional
	public void addNewCombat() {

		Combat b = new Combat();
		combatDAO.add(b);

	}

	@Transactional
	public List<Combat> listAllCombat() {
		return combatDAO.listCombat();
	}

	@Transactional
	public void löschen(int combat_id) {
		combatDAO.löschen(combat_id);
	}

	@Transactional
	public void update(Combat combat) {
		combatDAO.update(combat);
	}

	@Transactional
	public Combat getCombat(int combat_id) {
		return combatDAO.getCombat(combat_id);
	}

	@Transactional
	public boolean vorhanden(int combat_id) {
		return combatDAO.vorhanden(combat_id);
	}
}
