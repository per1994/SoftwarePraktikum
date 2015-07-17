package org.plp.dao;

import java.util.List;

import org.plp.gruppenfunktionen.Lernziel;

public interface LernzielDAO {
	public void add(Lernziel lernziel);

	public List<Lernziel> listLernziel();

	public void löschen(int lernziel_id);

	public void update(Lernziel lernziel);

	public Lernziel getLernziel(int lernziel_id);

	public boolean vorhanden(int lernziel_id);

}
