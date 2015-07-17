package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Kommentar;

public interface KommentarDAO {
	public void add(Kommentar kommentar);

	public List<Kommentar> listKommentar();

	public void löschen(int kommentar_id);

	public void update(Kommentar kommentar);

	public Kommentar getKommentar(int kommentar_id);

	public boolean vorhanden(int kommentar_id);

}
