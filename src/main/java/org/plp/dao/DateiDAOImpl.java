package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Datei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DateiDAOImpl implements DateiDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Datei datei) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(datei);

	}

	@Override
	public List<Datei> listDatei() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Datei> datei = session.createQuery("from Datei")
				.list();
		return datei;
	}

	@Override
	public void löschen(int datei_id) {
		Datei datei = (Datei) sessionFactory
				.getCurrentSession().load(Datei.class, datei_id);
		if (null != datei) {
			this.sessionFactory.getCurrentSession().delete(datei);
		}

	}

	@Override
	public void update(Datei datei) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(datei);

	}

	@Override
	public Datei getDatei(int datei_id) {
		Datei datei = (Datei) sessionFactory
				.getCurrentSession().get(Datei.class, datei_id);
		return datei;
	}

	@Override
	public boolean vorhanden(int datei_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Datei> datei = session.createQuery("from Datei")
				.list();
		boolean vorhanden = false;
		for (Datei b : datei) {
			if (b.getDatei_id() == datei_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
