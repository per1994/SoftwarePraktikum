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
	public List<Antwortmöglichkeit> listAntwortmöglichkeiten() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Antwortmöglichkeit> antwortmöglichkeiten = session.createQuery(
				"from Antwortmöglichkeit").list();
		return antwortmöglichkeiten;
	}

	@Override
	public void löschen(int antwortmöglichkeit_id) {
		Antwortmöglichkeit antwortmöglichkeit = (Antwortmöglichkeit) sessionFactory
				.getCurrentSession().load(Antwortmöglichkeit.class,
						antwortmöglichkeit_id);
		if (null != antwortmöglichkeit) {
			this.sessionFactory.getCurrentSession().delete(antwortmöglichkeit);
		}

	}

	@Override
	public boolean update(int antwortmöglichkeit_id) {
		Antwortmöglichkeit antwortmöglichkeit = (Antwortmöglichkeit) sessionFactory
				.getCurrentSession().load(Antwortmöglichkeit.class,
						antwortmöglichkeit_id);
		if (null != antwortmöglichkeit) {
			this.sessionFactory.getCurrentSession().update(antwortmöglichkeit);
			return true;
		} else {

			return false;

		}

	}

	@Override
	public Antwortmöglichkeit getAntwortmöglichkeit(int antwortmöglichkeit_id) {
		Antwortmöglichkeit antwortmöglichkeit = (Antwortmöglichkeit) sessionFactory
				.getCurrentSession().load(Antwortmöglichkeit.class,
						antwortmöglichkeit_id);
		return antwortmöglichkeit;
	}

}
