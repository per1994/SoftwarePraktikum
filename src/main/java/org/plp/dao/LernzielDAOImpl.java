package org.plp.dao;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gruppenfunktionen.Lernziel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LernzielDAOImpl implements LernzielDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Lernziel lernziel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(lernziel);

	}

	@Override
	public List<Lernziel> listLernziel() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Lernziel> lernziel = session.createQuery("from Lernziel")
				.list();
		return lernziel;
	}

	@Override
	public void löschen(int lernziel_id) {
		Lernziel lernziel = (Lernziel) sessionFactory
				.getCurrentSession().load(Lernziel.class, lernziel_id);
		if (null != lernziel) {
			this.sessionFactory.getCurrentSession().delete(lernziel);
		}

	}

	@Override
	public void update(Lernziel lernziel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(lernziel);

	}

	@Override
	public Lernziel getLernziel(int lernziel_id) {
		Lernziel lernziel = (Lernziel) sessionFactory
				.getCurrentSession().get(Lernziel.class, lernziel_id);
		return lernziel;
	}

	@Override
	public boolean vorhanden(int lernziel_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Lernziel> lernziel = session.createQuery("from Lernziel")
				.list();
		boolean vorhanden = false;
		for (Lernziel b : lernziel) {
			if (b.getLernziel_id() == lernziel_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
