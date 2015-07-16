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
	public List<Team> listTeams() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Team> teamen = session.createQuery(
				"from Team").list();
		return teamen;
	}

	@Override
	public void löschen(int team_id) {
		Team team = (Team) sessionFactory
				.getCurrentSession().load(Team.class,
						team_id);
		if (null != team) {
			this.sessionFactory.getCurrentSession().delete(team);
		}

	}

	@Override
	public boolean update(int team_id) {
		Team team = (Team) sessionFactory
				.getCurrentSession().load(Team.class,
						team_id);
		if (null != team) {
			this.sessionFactory.getCurrentSession().update(team);
			return true;
		} else {

			return false;

		}

	}

	@Override
	public Team getTeam(int team_id) {
		Team team = (Team) sessionFactory
				.getCurrentSession().load(Team.class,
						team_id);
		return team;
	}

}
