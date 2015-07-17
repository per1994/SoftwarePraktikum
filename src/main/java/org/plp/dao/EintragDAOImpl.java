package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Eintrag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EintragDAOImpl implements EintragDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Eintrag eintrag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(eintrag);

	}

	@Override
	public List<Eintrag> listEintrag() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Eintrag> eintrag = session.createQuery("from Eintrag")
				.list();
		return eintrag;
	}

	@Override
	public void löschen(int eintrag_id) {
		Eintrag eintrag = (Eintrag) sessionFactory
				.getCurrentSession().load(Eintrag.class, eintrag_id);
		if (null != eintrag) {
			this.sessionFactory.getCurrentSession().delete(eintrag);
		}

	}

	@Override
	public void update(Eintrag eintrag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(eintrag);

	}

	@Override
	public Eintrag getEintrag(int eintrag_id) {
		Eintrag eintrag = (Eintrag) sessionFactory
				.getCurrentSession().get(Eintrag.class, eintrag_id);
		return eintrag;
	}

	@Override
	public boolean vorhanden(int eintrag_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Eintrag> eintrag = session.createQuery("from Eintrag")
				.list();
		boolean vorhanden = false;
		for (Eintrag b : eintrag) {
			if (b.getEintrag_id() == eintrag_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
