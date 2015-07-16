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
	public void addNewAntwortmöglichkeit(String antwortmöglichkeitName) {
		System.out
				.println("Ich bin im Service, Methode addNewAntwortmöglichkeit");
		Antwortmöglichkeit antwortmöglichkeit = new Antwortmöglichkeit();
		antwortmöglichkeitDAO.add(antwortmöglichkeit);

	}

	@Transactional
	public List<Antwortmöglichkeit> listAllAntwortmöglichkeit() {
		return antwortmöglichkeitDAO.listAntwortmöglichkeiten();
	}

	@Transactional
	public void löschen(int antwortmöglichkeit_id) {
		antwortmöglichkeitDAO.löschen(antwortmöglichkeit_id);
	}

	@Transactional
	public void update(int antwortmöglichkeit_id) {
		antwortmöglichkeitDAO.update(antwortmöglichkeit_id);
	}

	@Transactional
	public Antwortmöglichkeit getAntwortmöglichkeit(int antwortmöglichkeit_id) {
		return antwortmöglichkeitDAO
				.getAntwortmöglichkeit(antwortmöglichkeit_id);
	}
}
