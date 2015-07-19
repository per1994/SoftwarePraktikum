package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Mediathek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediathekService {

	@Autowired
	private MediathekDAO mediathekDAO;

	@Transactional
	public void addNewMediathek(Mediathek b) {

		mediathekDAO.add(b);

	}

	@Transactional
	public List<Mediathek> listAllMediathek() {
		return mediathekDAO.listMediathek();
	}

	@Transactional
	public void löschen(int mediathek_id) {
		mediathekDAO.löschen(mediathek_id);
	}

	@Transactional
	public void update(Mediathek mediathek) {
		mediathekDAO.update(mediathek);
	}

	@Transactional
	public Mediathek getMediathek(int mediathek_id) {
		return mediathekDAO.getMediathek(mediathek_id);
	}

	@Transactional
	public boolean vorhanden(int mediathek_id) {
		return mediathekDAO.vorhanden(mediathek_id);
	}
}
