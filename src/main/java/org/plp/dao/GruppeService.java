package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.plp.gruppenfunktionen.Gruppe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GruppeService {

	@Autowired
	private GruppeDAO gruppeDAO;

	@Transactional
	public void addNewGruppe(String gruppeName) {

		
		Gruppe b = new Gruppe();
		b.setGruppenName(gruppeName);
		gruppeDAO.add(b);

	}

	@Transactional
	public List<Gruppe> listAllGruppe() {
		return gruppeDAO.listGruppe();
	}

	@Transactional
	public void löschen(int gruppe_id) {
		gruppeDAO.löschen(gruppe_id);
	}

	@Transactional
	public void update(Gruppe gruppe) {
		gruppeDAO.update(gruppe);
	}

	@Transactional
	public Gruppe getGruppe(int gruppe_id) {
		return gruppeDAO.getGruppe(gruppe_id);
	}

	@Transactional
	public boolean vorhanden(int gruppe_id) {
		return gruppeDAO.vorhanden(gruppe_id);
	}
}
