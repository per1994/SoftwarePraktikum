package org.plp.dao;

import java.util.List;

import org.plp.gamification.Aufgabe;

public interface AufgabeDAO {

	public void add(Aufgabe aufgabe);

	public List<Aufgabe> listAufgaben();

	public void löschen(int aufgabe_id);

	public boolean update(int aufgabe_id);

	public Aufgabe getAufgabe(int aufgabe_id);

}
