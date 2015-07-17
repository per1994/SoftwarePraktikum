package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gruppenfunktionen.Gruppe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GruppeDAOImpl implements GruppeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public void add(Gruppe gruppe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(gruppe);

	}

	@Override
	public List<Gruppe> listGruppe() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Gruppe> gruppe = session.createQuery("from Gruppe")
				.list();
		return gruppe;
	}

	@Override
	public void löschen(int gruppe_id) {
		Gruppe gruppe = (Gruppe) sessionFactory
				.getCurrentSession().load(Gruppe.class, gruppe_id);
		if (null != gruppe) {
			this.sessionFactory.getCurrentSession().delete(gruppe);
		}

	}

	@Override
	public void update(Gruppe gruppe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(gruppe);

	}

	@Override
	public Gruppe getGruppe(int gruppe_id) {
		Gruppe gruppe = (Gruppe) sessionFactory
				.getCurrentSession().get(Gruppe.class, gruppe_id);
		return gruppe;
	}

	@Override
	public boolean vorhanden(int gruppe_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Gruppe> gruppe = session.createQuery("from Gruppe")
				.list();
		boolean vorhanden = false;
		for (Gruppe b : gruppe) {
			if (b.getGruppe_id() == gruppe_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
