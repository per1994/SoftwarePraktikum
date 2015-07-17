package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.grundfunktionen.Nachricht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NachrichtService {

	@Autowired
	private NachrichtDAO nachrichtDAO;

	@Transactional
	public void addNewNachricht(int sender, int empfänger, int anhang) {

		Nachricht b = new Nachricht();
		nachrichtDAO.add(b);

	}

	@Transactional
	public List<Nachricht> listAllNachricht() {
		return nachrichtDAO.listNachricht();
	}

	@Transactional
	public void löschen(int nachricht_id) {
		nachrichtDAO.löschen(nachricht_id);
	}

	@Transactional
	public void update(Nachricht nachricht) {
		nachrichtDAO.update(nachricht);
	}

	@Transactional
	public Nachricht getNachricht(int nachricht_id) {
		return nachrichtDAO.getNachricht(nachricht_id);
	}

	@Transactional
	public boolean vorhanden(int nachricht_id) {
		return nachrichtDAO.vorhanden(nachricht_id);
	}
}
