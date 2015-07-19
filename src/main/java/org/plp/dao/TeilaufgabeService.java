package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Teilaufgabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeilaufgabeService {

	@Autowired
	private TeilaufgabeDAO teilaufgabeDAO;

	@Transactional
	public void addNewTeilaufgabe(Teilaufgabe b) {

		teilaufgabeDAO.add(b);

	}

	@Transactional
	public List<Teilaufgabe> listAllTeilaufgabe() {
		return teilaufgabeDAO.listTeilaufgabe();
	}

	@Transactional
	public void löschen(int teilaufgabe_id) {
		teilaufgabeDAO.löschen(teilaufgabe_id);
	}

	@Transactional
	public void update(Teilaufgabe teilaufgabe) {
		teilaufgabeDAO.update(teilaufgabe);
	}

	@Transactional
	public Teilaufgabe getTeilaufgabe(int teilaufgabe_id) {
		return teilaufgabeDAO.getTeilaufgabe(teilaufgabe_id);
	}

	@Transactional
	public boolean vorhanden(int teilaufgabe_id) {
		return teilaufgabeDAO.vorhanden(teilaufgabe_id);
	}
}
