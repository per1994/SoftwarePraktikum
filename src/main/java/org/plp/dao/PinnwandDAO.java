package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Pinnwand;

public interface PinnwandDAO {
	public void add(Pinnwand pinnwand);

	public List<Pinnwand> listPinnwand();

	public void löschen(int pinnwand_id);

	public void update(Pinnwand pinnwand);

	public Pinnwand getPinnwand(int pinnwand_id);

	public boolean vorhanden(int pinnwand_id);

}
