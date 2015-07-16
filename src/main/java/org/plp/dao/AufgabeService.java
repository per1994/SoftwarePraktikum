package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Aufgabe;
import org.springframework.beans.factory.annotation.Autowired;

public class AufgabeService {

	@Autowired
	private AufgabeDAO aufgabeDAO;

	@Transactional
	public void addNewAufgabe(String aufgabeName) {
		System.out.println("Ich bin im Service, Methode addNewAufgabe");
		Aufgabe aufgabe = new Aufgabe();
		aufgabeDAO.add(aufgabe);

	}

	@Transactional
	public List<Aufgabe> listAllAufgabe() {
		return aufgabeDAO.listAufgaben();
	}

	@Transactional
	public void löschen(int aufgabe_id) {
		aufgabeDAO.löschen(aufgabe_id);
	}

	@Transactional
	public void update(int aufgabe_id) {
		aufgabeDAO.update(aufgabe_id);
	}

	@Transactional
	public Aufgabe getAufgabe(int aufgabe_id) {
		return aufgabeDAO.getAufgabe(aufgabe_id);
	}
}
