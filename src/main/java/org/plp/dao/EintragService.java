package org.plp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Eintrag;
import org.plp.benutzer.Kommentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EintragService {

	@Autowired
	private EintragDAO eintragDAO;

	@Autowired
	private KommentarService kommentarService;

	@Transactional
	public void addNewEintrag(Eintrag b) {

		eintragDAO.add(b);

	}

	@Transactional
	public List<Eintrag> listAllEintrag() {
		return eintragDAO.listEintrag();
	}

	@Transactional
	public void löschen(int eintrag_id) {
		eintragDAO.löschen(eintrag_id);
	}

	@Transactional
	public void update(Eintrag eintrag) {
		eintragDAO.update(eintrag);
	}

	@Transactional
	public Eintrag getEintrag(int eintrag_id) {
		return eintragDAO.getEintrag(eintrag_id);
	}

	@Transactional
	public boolean vorhanden(int eintrag_id) {
		return eintragDAO.vorhanden(eintrag_id);
	}

	public void kommentareSortieren(int einrag) {
		ArrayList<Kommentar> hilfsListe = new ArrayList<Kommentar>();

		for (Kommentar kommentar : kommentarService.listAllKommentar()) {
			if (kommentar.getEintrag().getEintrag_id() == this.getEintrag(
					einrag).getEintrag_id()) {
				hilfsListe.add(kommentar);
			}
		}
		Kommentar temp;
		for (int i = 1; i < hilfsListe.size(); i++) {
			for (int j = 0; j < hilfsListe.size() - i; j++) {
				if (hilfsListe.get(j).getKommentar_id() < hilfsListe.get(j + 1)
						.getKommentar_id()) {
					temp = hilfsListe.get(j);
					hilfsListe.set(i, hilfsListe.get(j + 1));
					hilfsListe.set(j + 1, temp);
				}
			}
		}
	}
}
