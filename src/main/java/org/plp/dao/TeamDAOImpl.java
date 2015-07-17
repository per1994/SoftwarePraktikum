package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Team team) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(team);

	}

	@Override
	public List<Team> listTeam() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Team> team = session.createQuery("from Team")
				.list();
		return team;
	}

	@Override
	public void löschen(int team_id) {
		Team team = (Team) sessionFactory
				.getCurrentSession().load(Team.class, team_id);
		if (null != team) {
			this.sessionFactory.getCurrentSession().delete(team);
		}

	}

	@Override
	public void update(Team team) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(team);

	}

	@Override
	public Team getTeam(int team_id) {
		Team team = (Team) sessionFactory
				.getCurrentSession().get(Team.class, team_id);
		return team;
	}

	@Override
	public boolean vorhanden(int team_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Team> team = session.createQuery("from Team")
				.list();
		boolean vorhanden = false;
		for (Team b : team) {
			if (b.getTeam_id() == team_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
