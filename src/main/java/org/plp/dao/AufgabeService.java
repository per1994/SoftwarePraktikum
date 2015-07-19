package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Aufgabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AufgabeService {

	@Autowired
	private AufgabeDAO aufgabeDAO;

	@Transactional
	public void addNewAufgabe(Aufgabe b) {
		aufgabeDAO.add(b);

	}

	@Transactional
	public List<Aufgabe> listAllAufgabe() {
		return aufgabeDAO.listAufgabe();
	}

	@Transactional
	public void löschen(int aufgabe_id) {
		aufgabeDAO.löschen(aufgabe_id);
	}

	@Transactional
	public void update(Aufgabe aufgabe) {
		aufgabeDAO.update(aufgabe);
	}

	@Transactional
	public Aufgabe getAufgabe(int aufgabe_id) {
		return aufgabeDAO.getAufgabe(aufgabe_id);
	}

	@Transactional
	public boolean vorhanden(int aufgabe_id) {
		return aufgabeDAO.vorhanden(aufgabe_id);
	}
}
