package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AvatarDAOImpl implements AvatarDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Avatar avatar) {
		Session session= this.sessionFactory.getCurrentSession();
		session.persist(avatar);
		
		
	}

	@Override
	public List<Avatar> listAvatars() {
		Session session= this.sessionFactory.getCurrentSession();
		List<Avatar> avatar=session.createQuery("from Avatar").list();
		return avatar;
	}

	@Override
	public void löschen(int avatar_id) {
		Avatar avatar = (Avatar) sessionFactory.getCurrentSession().load(
                Avatar.class, avatar_id);
		if (null != avatar) {
            this.sessionFactory.getCurrentSession().delete(avatar);
        }
		
	}

	@Override
	public boolean update(int avatar_id) {
		Avatar avatar = (Avatar) sessionFactory.getCurrentSession().load(
                Avatar.class, avatar_id);
		if (null != avatar) {
            this.sessionFactory.getCurrentSession().update(avatar);
            return true;
        }else{
        	
        	return false;
        	
        }
		
	}

	@Override
	public Avatar getAvatar(int avatar_id) {
		Avatar avatar = (Avatar) sessionFactory.getCurrentSession().load(
                Avatar.class, avatar_id);
		return avatar;
	}

}
