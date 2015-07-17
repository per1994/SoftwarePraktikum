package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Datei;

public interface DateiDAO {
	public void add(Datei datei);

	public List<Datei> listDatei();

	public void löschen(int datei_id);

	public void update(Datei datei);

	public Datei getDatei(int datei_id);

	public boolean vorhanden(int datei_id);

}
