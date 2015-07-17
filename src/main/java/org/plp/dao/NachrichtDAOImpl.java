package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.grundfunktionen.Nachricht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NachrichtDAOImpl implements NachrichtDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Nachricht nachricht) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nachricht);

	}

	@Override
	public List<Nachricht> listNachricht() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Nachricht> nachricht = session.createQuery("from Nachricht")
				.list();
		return nachricht;
	}

	@Override
	public void löschen(int nachricht_id) {
		Nachricht nachricht = (Nachricht) sessionFactory
				.getCurrentSession().load(Nachricht.class, nachricht_id);
		if (null != nachricht) {
			this.sessionFactory.getCurrentSession().delete(nachricht);
		}

	}

	@Override
	public void update(Nachricht nachricht) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(nachricht);

	}

	@Override
	public Nachricht getNachricht(int nachricht_id) {
		Nachricht nachricht = (Nachricht) sessionFactory
				.getCurrentSession().get(Nachricht.class, nachricht_id);
		return nachricht;
	}

	@Override
	public boolean vorhanden(int nachricht_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Nachricht> nachricht = session.createQuery("from Nachricht")
				.list();
		boolean vorhanden = false;
		for (Nachricht b : nachricht) {
			if (b.getNachricht_id() == nachricht_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
