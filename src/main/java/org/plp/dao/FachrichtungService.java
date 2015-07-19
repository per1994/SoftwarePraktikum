package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gruppenfunktionen.Fachrichtung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FachrichtungService {

	@Autowired
	private FachrichtungDAO fachrichtungDAO;

	@Transactional
	public void addNewFachrichtung(Fachrichtung b) {

		
		fachrichtungDAO.add(b);

	}

	@Transactional
	public List<Fachrichtung> listAllFachrichtung() {
		return fachrichtungDAO.listFachrichtung();
	}

	@Transactional
	public void löschen(int fachrichtung_id) {
		fachrichtungDAO.löschen(fachrichtung_id);
	}

	@Transactional
	public void update(Fachrichtung fachrichtung) {
		fachrichtungDAO.update(fachrichtung);
	}

	@Transactional
	public Fachrichtung getFachrichtung(int fachrichtung_id) {
		return fachrichtungDAO.getFachrichtung(fachrichtung_id);
	}

	@Transactional
	public boolean vorhanden(int fachrichtung_id) {
		return fachrichtungDAO.vorhanden(fachrichtung_id);
	}
}
