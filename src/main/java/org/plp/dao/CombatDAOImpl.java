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
	public List<Combat> listCombat() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Combat> combat = session.createQuery("from Combat")
				.list();
		return combat;
	}

	@Override
	public void löschen(int combat_id) {
		Combat combat = (Combat) sessionFactory
				.getCurrentSession().load(Combat.class, combat_id);
		if (null != combat) {
			this.sessionFactory.getCurrentSession().delete(combat);
		}

	}

	@Override
	public void update(Combat combat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(combat);

	}

	@Override
	public Combat getCombat(int combat_id) {
		Combat combat = (Combat) sessionFactory
				.getCurrentSession().get(Combat.class, combat_id);
		return combat;
	}

	@Override
	public boolean vorhanden(int combat_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Combat> combat = session.createQuery("from Combat")
				.list();
		boolean vorhanden = false;
		for (Combat b : combat) {
			if (b.getCombat_id() == combat_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
