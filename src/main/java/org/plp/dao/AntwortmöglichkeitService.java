package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.gamification.Antwortmöglichkeit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AntwortmöglichkeitService {

	@Autowired
	private AntwortmöglichkeitDAO antwortmöglichkeitDAO;

	@Transactional
	public void addNewAntwortmöglichkeit() {

		Antwortmöglichkeit b = new Antwortmöglichkeit();
		antwortmöglichkeitDAO.add(b);

	}

	@Transactional
	public List<Antwortmöglichkeit> listAllAntwortmöglichkeit() {
		return antwortmöglichkeitDAO.listAntwortmöglichkeit();
	}

	@Transactional
	public void löschen(int antwortmöglichkeit_id) {
		antwortmöglichkeitDAO.löschen(antwortmöglichkeit_id);
	}

	@Transactional
	public void update(Antwortmöglichkeit antwortmöglichkeit) {
		antwortmöglichkeitDAO.update(antwortmöglichkeit);
	}

	@Transactional
	public Antwortmöglichkeit getAntwortmöglichkeit(int antwortmöglichkeit_id) {
		return antwortmöglichkeitDAO.getAntwortmöglichkeit(antwortmöglichkeit_id);
	}

	@Transactional
	public boolean vorhanden(int antwortmöglichkeit_id) {
		return antwortmöglichkeitDAO.vorhanden(antwortmöglichkeit_id);
	}
}
