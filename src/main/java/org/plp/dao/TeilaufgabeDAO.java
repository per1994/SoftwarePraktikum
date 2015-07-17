package org.plp.dao;

import java.util.List;

import org.plp.gamification.Teilaufgabe;

public interface TeilaufgabeDAO {
	public void add(Teilaufgabe teilaufgabe);

	public List<Teilaufgabe> listTeilaufgabe();

	public void löschen(int teilaufgabe_id);

	public void update(Teilaufgabe teilaufgabe);

	public Teilaufgabe getTeilaufgabe(int teilaufgabe_id);

	public boolean vorhanden(int teilaufgabe_id);

}
