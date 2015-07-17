package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Kommentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KommentarDAOImpl implements KommentarDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Kommentar kommentar) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(kommentar);

	}

	@Override
	public List<Kommentar> listKommentar() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Kommentar> kommentar = session.createQuery("from Kommentar")
				.list();
		return kommentar;
	}

	@Override
	public void löschen(int kommentar_id) {
		Kommentar kommentar = (Kommentar) sessionFactory
				.getCurrentSession().load(Kommentar.class, kommentar_id);
		if (null != kommentar) {
			this.sessionFactory.getCurrentSession().delete(kommentar);
		}

	}

	@Override
	public void update(Kommentar kommentar) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(kommentar);

	}

	@Override
	public Kommentar getKommentar(int kommentar_id) {
		Kommentar kommentar = (Kommentar) sessionFactory
				.getCurrentSession().get(Kommentar.class, kommentar_id);
		return kommentar;
	}

	@Override
	public boolean vorhanden(int kommentar_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Kommentar> kommentar = session.createQuery("from Kommentar")
				.list();
		boolean vorhanden = false;
		for (Kommentar b : kommentar) {
			if (b.getKommentar_id() == kommentar_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
