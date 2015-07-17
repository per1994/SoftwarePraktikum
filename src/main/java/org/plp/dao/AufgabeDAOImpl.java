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
	public List<Aufgabe> listAufgabe() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Aufgabe> aufgabe = session.createQuery("from Aufgabe")
				.list();
		return aufgabe;
	}

	@Override
	public void löschen(int aufgabe_id) {
		Aufgabe aufgabe = (Aufgabe) sessionFactory
				.getCurrentSession().load(Aufgabe.class, aufgabe_id);
		if (null != aufgabe) {
			this.sessionFactory.getCurrentSession().delete(aufgabe);
		}

	}

	@Override
	public void update(Aufgabe aufgabe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(aufgabe);

	}

	@Override
	public Aufgabe getAufgabe(int aufgabe_id) {
		Aufgabe aufgabe = (Aufgabe) sessionFactory
				.getCurrentSession().get(Aufgabe.class, aufgabe_id);
		return aufgabe;
	}

	@Override
	public boolean vorhanden(int aufgabe_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Aufgabe> aufgabe = session.createQuery("from Aufgabe")
				.list();
		boolean vorhanden = false;
		for (Aufgabe b : aufgabe) {
			if (b.getAufgabe_id() == aufgabe_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
