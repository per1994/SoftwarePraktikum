package org.plp.dao;

import java.util.List;

import org.plp.gamification.Aufgabe;

public interface AufgabeDAO {
	public void add(Aufgabe aufgabe);

	public List<Aufgabe> listAufgabe();

	public void löschen(int aufgabe_id);

	public void update(Aufgabe aufgabe);

	public Aufgabe getAufgabe(int aufgabe_id);

	public boolean vorhanden(int aufgabe_id);

}
