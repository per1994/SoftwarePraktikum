package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.gamification.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestDAOImpl implements QuestDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Quest quest) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(quest);

	}

	@Override
	public List<Quest> listQuest() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Quest> quest = session.createQuery("from Quest")
				.list();
		return quest;
	}

	@Override
	public void löschen(int quest_id) {
		Quest quest = (Quest) sessionFactory
				.getCurrentSession().load(Quest.class, quest_id);
		if (null != quest) {
			this.sessionFactory.getCurrentSession().delete(quest);
		}

	}

	@Override
	public void update(Quest quest) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(quest);

	}

	@Override
	public Quest getQuest(int quest_id) {
		Quest quest = (Quest) sessionFactory
				.getCurrentSession().get(Quest.class, quest_id);
		return quest;
	}

	@Override
	public boolean vorhanden(int quest_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Quest> quest = session.createQuery("from Quest")
				.list();
		boolean vorhanden = false;
		for (Quest b : quest) {
			if (b.getQuest_id() == quest_id) {
				vorhanden = true;
			}
		}

		return vorhanden;

	}

}
