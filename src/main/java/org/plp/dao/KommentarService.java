package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Kommentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KommentarService {

	@Autowired
	private KommentarDAO kommentarDAO;

	@Transactional
	public void addNewKommentar(Kommentar b) {

		kommentarDAO.add(b);

	}

	@Transactional
	public List<Kommentar> listAllKommentar() {
		return kommentarDAO.listKommentar();
	}

	@Transactional
	public void löschen(int kommentar_id) {
		kommentarDAO.löschen(kommentar_id);
	}

	@Transactional
	public void update(Kommentar kommentar) {
		kommentarDAO.update(kommentar);
	}

	@Transactional
	public Kommentar getKommentar(int kommentar_id) {
		return kommentarDAO.getKommentar(kommentar_id);
	}

	@Transactional
	public boolean vorhanden(int kommentar_id) {
		return kommentarDAO.vorhanden(kommentar_id);
	}
}
