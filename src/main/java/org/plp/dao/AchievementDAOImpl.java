package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AchievementDAOImpl implements AchievementDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Achievement achievement) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(achievement);

	}

	@Override
	public List<Achievement> listAchievement() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Achievement> achievement = session.createQuery("from Achievement")
				.list();
		return achievement;
	}

	@Override
	public void l�schen(int achievement_id) {
		Achievement achievement = (Achievement) sessionFactory
				.getCurrentSession().load(Achievement.class, achievement_id);
		if (null != achievement) {
			this.sessionFactory.getCurrentSession().delete(achievement);
		}

	}

	@Override
	public void update(Achievement achievement) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(achievement);

	}

	@Override
	public Achievement getAchievement(int achievement_id) {
		Achievement achievement = (Achievement) sessionFactory
				.getCurrentSession().get(Achievement.class, achievement_id);
		return achievement;
	}

	@Override
	public boolean vorhanden(int achievement_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Achievement> achievement = session.createQuery("from Achievement")
				.list();
		boolean vorhanden = false;
		for (Achievement b : achievement) {
			if (b.getAchievement_id() == achievement_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
