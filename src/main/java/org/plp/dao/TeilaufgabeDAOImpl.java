package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Teilaufgabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeilaufgabeDAOImpl implements TeilaufgabeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Teilaufgabe teilaufgabe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(teilaufgabe);

	}

	@Override
	public List<Teilaufgabe> listTeilaufgabe() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Teilaufgabe> teilaufgabe = session.createQuery("from Teilaufgabe")
				.list();
		return teilaufgabe;
	}

	@Override
	public void löschen(int teilaufgabe_id) {
		Teilaufgabe teilaufgabe = (Teilaufgabe) sessionFactory
				.getCurrentSession().load(Teilaufgabe.class, teilaufgabe_id);
		if (null != teilaufgabe) {
			this.sessionFactory.getCurrentSession().delete(teilaufgabe);
		}

	}

	@Override
	public void update(Teilaufgabe teilaufgabe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(teilaufgabe);

	}

	@Override
	public Teilaufgabe getTeilaufgabe(int teilaufgabe_id) {
		Teilaufgabe teilaufgabe = (Teilaufgabe) sessionFactory
				.getCurrentSession().get(Teilaufgabe.class, teilaufgabe_id);
		return teilaufgabe;
	}

	@Override
	public boolean vorhanden(int teilaufgabe_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Teilaufgabe> teilaufgabe = session.createQuery("from Teilaufgabe")
				.list();
		boolean vorhanden = false;
		for (Teilaufgabe b : teilaufgabe) {
			if (b.getTeilaufgabe_id() == teilaufgabe_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
