package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Mediathek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MediathekDAOImpl implements MediathekDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Mediathek mediathek) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(mediathek);

	}

	@Override
	public List<Mediathek> listMediathek() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Mediathek> mediathek = session.createQuery("from Mediathek")
				.list();
		return mediathek;
	}

	@Override
	public void löschen(int mediathek_id) {
		Mediathek mediathek = (Mediathek) sessionFactory
				.getCurrentSession().load(Mediathek.class, mediathek_id);
		if (null != mediathek) {
			this.sessionFactory.getCurrentSession().delete(mediathek);
		}

	}

	@Override
	public void update(Mediathek mediathek) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(mediathek);

	}

	@Override
	public Mediathek getMediathek(int mediathek_id) {
		Mediathek mediathek = (Mediathek) sessionFactory
				.getCurrentSession().get(Mediathek.class, mediathek_id);
		return mediathek;
	}

	@Override
	public boolean vorhanden(int mediathek_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Mediathek> mediathek = session.createQuery("from Mediathek")
				.list();
		boolean vorhanden = false;
		for (Mediathek b : mediathek) {
			if (b.getMediathek_id() == mediathek_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
