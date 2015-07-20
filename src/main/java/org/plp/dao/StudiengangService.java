package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Studiengang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudiengangService {

	@Autowired
	private StudiengangDAO studiengangDAO;

	@Transactional
	public void addNewStudiengang(Studiengang b) {

		
		studiengangDAO.add(b);

	}

	@Transactional
	public List<Studiengang> listAllStudiengang() {
		return studiengangDAO.listStudiengang();
	}

	@Transactional
	public void löschen(int studiengang_id) {
		studiengangDAO.löschen(studiengang_id);
	}

	@Transactional
	public void update(Studiengang studiengang) {
		studiengangDAO.update(studiengang);
	}

	@Transactional
	public Studiengang getStudiengang(int studiengang_id) {
		return studiengangDAO.getStudiengang(studiengang_id);
	}

	@Transactional
	public boolean vorhanden(int studiengang_id) {
		return studiengangDAO.vorhanden(studiengang_id);
	}
}
