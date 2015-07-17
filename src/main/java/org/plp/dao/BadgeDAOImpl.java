package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BadgeDAOImpl implements BadgeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Badge badge) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(badge);

	}

	@Override
	public List<Badge> listBadge() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Badge> badge = session.createQuery("from Badge")
				.list();
		return badge;
	}

	@Override
	public void löschen(int badge_id) {
		Badge badge = (Badge) sessionFactory
				.getCurrentSession().load(Badge.class, badge_id);
		if (null != badge) {
			this.sessionFactory.getCurrentSession().delete(badge);
		}

	}

	@Override
	public void update(Badge badge) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(badge);

	}

	@Override
	public Badge getBadge(int badge_id) {
		Badge badge = (Badge) sessionFactory
				.getCurrentSession().get(Badge.class, badge_id);
		return badge;
	}

	@Override
	public boolean vorhanden(int badge_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Badge> badge = session.createQuery("from Badge")
				.list();
		boolean vorhanden = false;
		for (Badge b : badge) {
			if (b.getBadge_id() == badge_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
