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
	public List<Quest> listQuests() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Quest> questen = session.createQuery(
				"from Quest").list();
		return questen;
	}

	@Override
	public void löschen(int quest_id) {
		Quest quest = (Quest) sessionFactory
				.getCurrentSession().load(Quest.class,
						quest_id);
		if (null != quest) {
			this.sessionFactory.getCurrentSession().delete(quest);
		}

	}

	@Override
	public boolean update(int quest_id) {
		Quest quest = (Quest) sessionFactory
				.getCurrentSession().load(Quest.class,
						quest_id);
		if (null != quest) {
			this.sessionFactory.getCurrentSession().update(quest);
			return true;
		} else {

			return false;

		}

	}

	@Override
	public Quest getQuest(int quest_id) {
		Quest quest = (Quest) sessionFactory
				.getCurrentSession().load(Quest.class,
						quest_id);
		return quest;
	}

}
