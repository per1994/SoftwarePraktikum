package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Pinnwand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinnwandService {

	@Autowired
	private PinnwandDAO pinnwandDAO;

	@Transactional
	public void addNewPinnwand() {

		Pinnwand b = new Pinnwand();
		pinnwandDAO.add(b);

	}

	@Transactional
	public List<Pinnwand> listAllPinnwand() {
		return pinnwandDAO.listPinnwand();
	}

	@Transactional
	public void l�schen(int pinnwand_id) {
		pinnwandDAO.l�schen(pinnwand_id);
	}

	@Transactional
	public void update(Pinnwand pinnwand) {
		pinnwandDAO.update(pinnwand);
	}

	@Transactional
	public Pinnwand getPinnwand(int pinnwand_id) {
		return pinnwandDAO.getPinnwand(pinnwand_id);
	}

	@Transactional
	public boolean vorhanden(int pinnwand_id) {
		return pinnwandDAO.vorhanden(pinnwand_id);
	}
}
