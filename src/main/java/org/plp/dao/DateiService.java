package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Datei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateiService {

	@Autowired
	private DateiDAO dateiDAO;

	@Transactional
	public void addNewDatei() {

		Datei b = new Datei();
		dateiDAO.add(b);

	}

	@Transactional
	public List<Datei> listAllDatei() {
		return dateiDAO.listDatei();
	}

	@Transactional
	public void löschen(int datei_id) {
		dateiDAO.löschen(datei_id);
	}

	@Transactional
	public void update(Datei datei) {
		dateiDAO.update(datei);
	}

	@Transactional
	public Datei getDatei(int datei_id) {
		return dateiDAO.getDatei(datei_id);
	}

	@Transactional
	public boolean vorhanden(int datei_id) {
		return dateiDAO.vorhanden(datei_id);
	}
}
