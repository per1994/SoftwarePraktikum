package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Teamcombat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamcombatDAOImpl implements TeamcombatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Teamcombat teamcombat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(teamcombat);

	}

	@Override
	public List<Teamcombat> listTeamcombat() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Teamcombat> teamcombat = session.createQuery("from Teamcombat")
				.list();
		return teamcombat;
	}

	@Override
	public void löschen(int teamcombat_id) {
		Teamcombat teamcombat = (Teamcombat) sessionFactory
				.getCurrentSession().load(Teamcombat.class, teamcombat_id);
		if (null != teamcombat) {
			this.sessionFactory.getCurrentSession().delete(teamcombat);
		}

	}

	@Override
	public void update(Teamcombat teamcombat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(teamcombat);

	}

	@Override
	public Teamcombat getTeamcombat(int teamcombat_id) {
		Teamcombat teamcombat = (Teamcombat) sessionFactory
				.getCurrentSession().get(Teamcombat.class, teamcombat_id);
		return teamcombat;
	}

	@Override
	public boolean vorhanden(int teamcombat_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Teamcombat> teamcombat = session.createQuery("from Teamcombat")
				.list();
		boolean vorhanden = false;
		for (Teamcombat b : teamcombat) {
			if (b.getTeamcombat_id() == teamcombat_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
