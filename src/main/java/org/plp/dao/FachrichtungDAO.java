package org.plp.dao;

import java.util.List;

import org.plp.gruppenfunktionen.Fachrichtung;

public interface FachrichtungDAO {
	public void add(Fachrichtung fachrichtung);

	public List<Fachrichtung> listFachrichtung();

	public void löschen(int fachrichtung_id);

	public void update(Fachrichtung fachrichtung);

	public Fachrichtung getFachrichtung(int fachrichtung_id);

	public boolean vorhanden(int fachrichtung_id);

}
