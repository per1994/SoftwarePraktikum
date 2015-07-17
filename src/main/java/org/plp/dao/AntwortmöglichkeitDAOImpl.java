package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Antwortmöglichkeit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AntwortmöglichkeitDAOImpl implements AntwortmöglichkeitDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Antwortmöglichkeit antwortmöglichkeit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(antwortmöglichkeit);

	}

	@Override
	public List<Antwortmöglichkeit> listAntwortmöglichkeit() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Antwortmöglichkeit> antwortmöglichkeit = session.createQuery("from Antwortmöglichkeit")
				.list();
		return antwortmöglichkeit;
	}

	@Override
	public void löschen(int antwortmöglichkeit_id) {
		Antwortmöglichkeit antwortmöglichkeit = (Antwortmöglichkeit) sessionFactory
				.getCurrentSession().load(Antwortmöglichkeit.class, antwortmöglichkeit_id);
		if (null != antwortmöglichkeit) {
			this.sessionFactory.getCurrentSession().delete(antwortmöglichkeit);
		}

	}

	@Override
	public void update(Antwortmöglichkeit antwortmöglichkeit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(antwortmöglichkeit);

	}

	@Override
	public Antwortmöglichkeit getAntwortmöglichkeit(int antwortmöglichkeit_id) {
		Antwortmöglichkeit antwortmöglichkeit = (Antwortmöglichkeit) sessionFactory
				.getCurrentSession().get(Antwortmöglichkeit.class, antwortmöglichkeit_id);
		return antwortmöglichkeit;
	}

	@Override
	public boolean vorhanden(int antwortmöglichkeit_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Antwortmöglichkeit> antwortmöglichkeit = session.createQuery("from Antwortmöglichkeit")
				.list();
		boolean vorhanden = false;
		for (Antwortmöglichkeit b : antwortmöglichkeit) {
			if (b.getAntwortmoeglichkeit_id() == antwortmöglichkeit_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
