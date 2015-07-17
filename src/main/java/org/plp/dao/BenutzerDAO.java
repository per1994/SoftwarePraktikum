package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Benutzer;

public interface BenutzerDAO {
	public void add(Benutzer benutzer);

	public List<Benutzer> listBenutzer();

	public void löschen(int benutzer_id);

	public void update(Benutzer benutzer);

	public Benutzer getBenutzer(int benutzer_id);

}
