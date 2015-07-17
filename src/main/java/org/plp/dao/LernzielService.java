package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gruppenfunktionen.Lernziel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LernzielService {

	@Autowired
	private LernzielDAO lernzielDAO;

	@Transactional
	public void addNewLernziel() {

		Lernziel b = new Lernziel();
		lernzielDAO.add(b);

	}

	@Transactional
	public List<Lernziel> listAllLernziel() {
		return lernzielDAO.listLernziel();
	}

	@Transactional
	public void löschen(int lernziel_id) {
		lernzielDAO.löschen(lernziel_id);
	}

	@Transactional
	public void update(Lernziel lernziel) {
		lernzielDAO.update(lernziel);
	}

	@Transactional
	public Lernziel getLernziel(int lernziel_id) {
		return lernzielDAO.getLernziel(lernziel_id);
	}

	@Transactional
	public boolean vorhanden(int lernziel_id) {
		return lernzielDAO.vorhanden(lernziel_id);
	}
}
