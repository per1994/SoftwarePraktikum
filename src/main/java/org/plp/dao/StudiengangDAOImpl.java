package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Studiengang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudiengangDAOImpl implements StudiengangDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Studiengang studiengang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(studiengang);

	}

	@Override
	public List<Studiengang> listStudiengang() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Studiengang> studiengang = session.createQuery("from Studiengang")
				.list();
		return studiengang;
	}

	@Override
	public void löschen(int studiengang_id) {
		Studiengang studiengang = (Studiengang) sessionFactory
				.getCurrentSession().load(Studiengang.class, studiengang_id);
		if (null != studiengang) {
			this.sessionFactory.getCurrentSession().delete(studiengang);
		}

	}

	@Override
	public void update(Studiengang studiengang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(studiengang);

	}

	@Override
	public Studiengang getStudiengang(int studiengang_id) {
		Studiengang studiengang = (Studiengang) sessionFactory
				.getCurrentSession().get(Studiengang.class, studiengang_id);
		return studiengang;
	}

	@Override
	public boolean vorhanden(int studiengang_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Studiengang> studiengang = session.createQuery("from Studiengang")
				.list();
		boolean vorhanden = false;
		for (Studiengang b : studiengang) {
			if (b.getStudiengang_id() == studiengang_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
