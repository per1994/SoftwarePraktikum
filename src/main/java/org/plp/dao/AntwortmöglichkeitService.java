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
	public void addNewAntwortm�glichkeit(String antwortm�glichkeitName) {
		System.out
				.println("Ich bin im Service, Methode addNewAntwortm�glichkeit");
		Antwortm�glichkeit antwortm�glichkeit = new Antwortm�glichkeit();
		antwortm�glichkeitDAO.add(antwortm�glichkeit);

	}

	@Transactional
	public List<Antwortm�glichkeit> listAllAntwortm�glichkeit() {
		return antwortm�glichkeitDAO.listAntwortm�glichkeiten();
	}

	@Transactional
	public void l�schen(int antwortm�glichkeit_id) {
		antwortm�glichkeitDAO.l�schen(antwortm�glichkeit_id);
	}

	@Transactional
	public void update(int antwortm�glichkeit_id) {
		antwortm�glichkeitDAO.update(antwortm�glichkeit_id);
	}

	@Transactional
	public Antwortm�glichkeit getAntwortm�glichkeit(int antwortm�glichkeit_id) {
		return antwortm�glichkeitDAO
				.getAntwortm�glichkeit(antwortm�glichkeit_id);
	}
}
