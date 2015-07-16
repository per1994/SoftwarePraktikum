package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Benutzer;

public interface BenutzerDAO {
	public void add(Benutzer benutzer);
	public List<Benutzer> listBenutzer();
	public void l�schen(int benutzer_id);
	public boolean update(int benutzer_id);
	public Benutzer getBenutzer(int benutzer_id);

}
