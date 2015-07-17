package org.plp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.plp.benutzer.Benutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BenutzerDAOImpl implements BenutzerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Benutzer benutzer) {
		Session session= this.sessionFactory.getCurrentSession();
		session.persist(benutzer);
		
		
		
	}

	@Override
	public List<Benutzer> listBenutzer() {
		Session session= this.sessionFactory.getCurrentSession();
		List<Benutzer> benutzer=session.createQuery("from Benutzer").list();
		return benutzer;
	}

	@Override
	public void löschen(int benutzer_id) {
		Benutzer benutzer = (Benutzer) sessionFactory.getCurrentSession().load(
                Benutzer.class, benutzer_id);
		if (null != benutzer) {
            this.sessionFactory.getCurrentSession().delete(benutzer);
        }
		
	}

	@Override
	public void update(Benutzer benutzer) {
		Session session= this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(benutzer);
		
		
		
	}

	@Override
	public Benutzer getBenutzer(int benutzer_id) {
		Benutzer benutzer = (Benutzer) sessionFactory.getCurrentSession().get(
                Benutzer.class, benutzer_id);
		return benutzer;
	}

	@Override
	public boolean vorhanden(int benutzer_id) {
		Session session= this.sessionFactory.getCurrentSession();
		List<Benutzer> benutzer=session.createQuery("from Benutzer").list();
		boolean vorhanden=false;
		for (Benutzer b: benutzer){
			if(b.getBenutzer_id()==benutzer_id){
				vorhanden=true;
			}
		}
		
		return vorhanden;
		
	}

}
