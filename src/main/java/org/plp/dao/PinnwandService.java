package org.plp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Badge;
import org.plp.benutzer.Eintrag;
import org.plp.benutzer.Pinnwand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinnwandService {

	@Autowired
	private PinnwandDAO pinnwandDAO;

	@Autowired
	private EintragService eintragService;

	@Transactional
	public void addNewPinnwand(Pinnwand b) {

		pinnwandDAO.add(b);

	}

	@Transactional
	public List<Pinnwand> listAllPinnwand() {
		return pinnwandDAO.listPinnwand();
	}

	@Transactional
	public void löschen(int pinnwand_id) {
		pinnwandDAO.löschen(pinnwand_id);
	}

	@Transactional
	public void update(Pinnwand pinnwand) {
		pinnwandDAO.update(pinnwand);
	}

	@Transactional
	public Pinnwand getPinnwand(int pinnwand_id) {
		return pinnwandDAO.getPinnwand(pinnwand_id);
	}

	@Transactional
	public boolean vorhanden(int pinnwand_id) {
		return pinnwandDAO.vorhanden(pinnwand_id);
	}

	public ArrayList einträgeSortieren(int pinnwand) {
		ArrayList<Eintrag> hilfsListe = new ArrayList<Eintrag>();

		for (Eintrag eintrag : eintragService.listAllEintrag()) {
			if (eintrag.getPinnwand().getPinnwand_id() == this.getPinnwand(
					pinnwand).getPinnwand_id()) {
				hilfsListe.add(eintrag);
			}
		}
		Eintrag temp;
		for (int i = 1; i < hilfsListe.size(); i++) {
			for (int j = 0; j < hilfsListe.size() - i; j++) {
				if (hilfsListe.get(j).getEintrag_id() < hilfsListe.get(j + 1)
						.getEintrag_id()) {
					temp = hilfsListe.get(j);
					hilfsListe.set(i, hilfsListe.get(j + 1));
					hilfsListe.set(j + 1, temp);
				}
			}
		}
		return hilfsListe;
	}
}
