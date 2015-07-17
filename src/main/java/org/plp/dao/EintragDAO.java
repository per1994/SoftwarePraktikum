package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Eintrag;

public interface EintragDAO {
	public void add(Eintrag eintrag);

	public List<Eintrag> listEintrag();

	public void löschen(int eintrag_id);

	public void update(Eintrag eintrag);

	public Eintrag getEintrag(int eintrag_id);

	public boolean vorhanden(int eintrag_id);

}
