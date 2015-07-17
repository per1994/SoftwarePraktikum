package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Antwortm�glichkeit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Antwortm�glichkeitService {

	@Autowired
	private Antwortm�glichkeitDAO antwortm�glichkeitDAO;

	@Transactional
	public void addNewAntwortm�glichkeit() {

		Antwortm�glichkeit b = new Antwortm�glichkeit();
		antwortm�glichkeitDAO.add(b);

	}

	@Transactional
	public List<Antwortm�glichkeit> listAllAntwortm�glichkeit() {
		return antwortm�glichkeitDAO.listAntwortm�glichkeit();
	}

	@Transactional
	public void l�schen(int antwortm�glichkeit_id) {
		antwortm�glichkeitDAO.l�schen(antwortm�glichkeit_id);
	}

	@Transactional
	public void update(Antwortm�glichkeit antwortm�glichkeit) {
		antwortm�glichkeitDAO.update(antwortm�glichkeit);
	}

	@Transactional
	public Antwortm�glichkeit getAntwortm�glichkeit(int antwortm�glichkeit_id) {
		return antwortm�glichkeitDAO.getAntwortm�glichkeit(antwortm�glichkeit_id);
	}

	@Transactional
	public boolean vorhanden(int antwortm�glichkeit_id) {
		return antwortm�glichkeitDAO.vorhanden(antwortm�glichkeit_id);
	}
}
