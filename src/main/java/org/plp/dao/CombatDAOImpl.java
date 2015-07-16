package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Combat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CombatDAOImpl implements CombatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Combat combat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(combat);

	}

	@Override
	public List<Combat> listCombats() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Combat> combaten = session.createQuery(
				"from Combat").list();
		return combaten;
	}

	@Override
	public void löschen(int combat_id) {
		Combat combat = (Combat) sessionFactory
				.getCurrentSession().load(Combat.class,
						combat_id);
		if (null != combat) {
			this.sessionFactory.getCurrentSession().delete(combat);
		}

	}

	@Override
	public boolean update(int combat_id) {
		Combat combat = (Combat) sessionFactory
				.getCurrentSession().load(Combat.class,
						combat_id);
		if (null != combat) {
			this.sessionFactory.getCurrentSession().update(combat);
			return true;
		} else {

			return false;

		}

	}

	@Override
	public Combat getCombat(int combat_id) {
		Combat combat = (Combat) sessionFactory
				.getCurrentSession().load(Combat.class,
						combat_id);
		return combat;
	}

}
