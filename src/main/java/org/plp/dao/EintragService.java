package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Eintrag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EintragService {

	@Autowired
	private EintragDAO eintragDAO;

	@Transactional
	public void addNewEintrag(Eintrag b) {

		eintragDAO.add(b);

	}

	@Transactional
	public List<Eintrag> listAllEintrag() {
		return eintragDAO.listEintrag();
	}

	@Transactional
	public void löschen(int eintrag_id) {
		eintragDAO.löschen(eintrag_id);
	}

	@Transactional
	public void update(Eintrag eintrag) {
		eintragDAO.update(eintrag);
	}

	@Transactional
	public Eintrag getEintrag(int eintrag_id) {
		return eintragDAO.getEintrag(eintrag_id);
	}

	@Transactional
	public boolean vorhanden(int eintrag_id) {
		return eintragDAO.vorhanden(eintrag_id);
	}
}
