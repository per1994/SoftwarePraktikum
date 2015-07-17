package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Pinnwand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PinnwandDAOImpl implements PinnwandDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Pinnwand pinnwand) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(pinnwand);

	}

	@Override
	public List<Pinnwand> listPinnwand() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pinnwand> pinnwand = session.createQuery("from Pinnwand")
				.list();
		return pinnwand;
	}

	@Override
	public void löschen(int pinnwand_id) {
		Pinnwand pinnwand = (Pinnwand) sessionFactory
				.getCurrentSession().load(Pinnwand.class, pinnwand_id);
		if (null != pinnwand) {
			this.sessionFactory.getCurrentSession().delete(pinnwand);
		}

	}

	@Override
	public void update(Pinnwand pinnwand) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(pinnwand);

	}

	@Override
	public Pinnwand getPinnwand(int pinnwand_id) {
		Pinnwand pinnwand = (Pinnwand) sessionFactory
				.getCurrentSession().get(Pinnwand.class, pinnwand_id);
		return pinnwand;
	}

	@Override
	public boolean vorhanden(int pinnwand_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pinnwand> pinnwand = session.createQuery("from Pinnwand")
				.list();
		boolean vorhanden = false;
		for (Pinnwand b : pinnwand) {
			if (b.getPinnwand_id() == pinnwand_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
