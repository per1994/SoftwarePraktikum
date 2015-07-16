package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Antwortm�glichkeit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Antwortm�glichkeitDAOImpl implements Antwortm�glichkeitDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Antwortm�glichkeit antwortm�glichkeit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(antwortm�glichkeit);

	}

	@Override
	public List<Antwortm�glichkeit> listAntwortm�glichkeiten() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Antwortm�glichkeit> antwortm�glichkeiten = session.createQuery(
				"from Antwortm�glichkeit").list();
		return antwortm�glichkeiten;
	}

	@Override
	public void l�schen(int antwortm�glichkeit_id) {
		Antwortm�glichkeit antwortm�glichkeit = (Antwortm�glichkeit) sessionFactory
				.getCurrentSession().load(Antwortm�glichkeit.class,
						antwortm�glichkeit_id);
		if (null != antwortm�glichkeit) {
			this.sessionFactory.getCurrentSession().delete(antwortm�glichkeit);
		}

	}

	@Override
	public boolean update(int antwortm�glichkeit_id) {
		Antwortm�glichkeit antwortm�glichkeit = (Antwortm�glichkeit) sessionFactory
				.getCurrentSession().load(Antwortm�glichkeit.class,
						antwortm�glichkeit_id);
		if (null != antwortm�glichkeit) {
			this.sessionFactory.getCurrentSession().update(antwortm�glichkeit);
			return true;
		} else {

			return false;

		}

	}

	@Override
	public Antwortm�glichkeit getAntwortm�glichkeit(int antwortm�glichkeit_id) {
		Antwortm�glichkeit antwortm�glichkeit = (Antwortm�glichkeit) sessionFactory
				.getCurrentSession().load(Antwortm�glichkeit.class,
						antwortm�glichkeit_id);
		return antwortm�glichkeit;
	}

}
