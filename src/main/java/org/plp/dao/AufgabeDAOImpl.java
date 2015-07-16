package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Aufgabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AufgabeDAOImpl implements AufgabeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Aufgabe aufgabe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(aufgabe);

	}

	@Override
	public List<Aufgabe> listAufgaben() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Aufgabe> aufgabeen = session.createQuery(
				"from Aufgabe").list();
		return aufgabeen;
	}

	@Override
	public void löschen(int aufgabe_id) {
		Aufgabe aufgabe = (Aufgabe) sessionFactory
				.getCurrentSession().load(Aufgabe.class,
						aufgabe_id);
		if (null != aufgabe) {
			this.sessionFactory.getCurrentSession().delete(aufgabe);
		}

	}

	@Override
	public boolean update(int aufgabe_id) {
		Aufgabe aufgabe = (Aufgabe) sessionFactory
				.getCurrentSession().load(Aufgabe.class,
						aufgabe_id);
		if (null != aufgabe) {
			this.sessionFactory.getCurrentSession().update(aufgabe);
			return true;
		} else {

			return false;

		}

	}

	@Override
	public Aufgabe getAufgabe(int aufgabe_id) {
		Aufgabe aufgabe = (Aufgabe) sessionFactory
				.getCurrentSession().load(Aufgabe.class,
						aufgabe_id);
		return aufgabe;
	}

}
