package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FachrichtungDAOImpl implements FachrichtungDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Fachrichtung fachrichtung) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(fachrichtung);

	}

	@Override
	public List<Fachrichtung> listFachrichtung() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Fachrichtung> fachrichtung = session.createQuery("from Fachrichtung")
				.list();
		return fachrichtung;
	}

	@Override
	public void löschen(int fachrichtung_id) {
		Fachrichtung fachrichtung = (Fachrichtung) sessionFactory
				.getCurrentSession().load(Fachrichtung.class, fachrichtung_id);
		if (null != fachrichtung) {
			this.sessionFactory.getCurrentSession().delete(fachrichtung);
		}

	}

	@Override
	public void update(Fachrichtung fachrichtung) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(fachrichtung);

	}

	@Override
	public Fachrichtung getFachrichtung(int fachrichtung_id) {
		Fachrichtung fachrichtung = (Fachrichtung) sessionFactory
				.getCurrentSession().get(Fachrichtung.class, fachrichtung_id);
		return fachrichtung;
	}

	@Override
	public boolean vorhanden(int fachrichtung_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Fachrichtung> fachrichtung = session.createQuery("from Fachrichtung")
				.list();
		boolean vorhanden = false;
		for (Fachrichtung b : fachrichtung) {
			if (b.getFachrichtung_id() == fachrichtung_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
