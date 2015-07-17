package org.plp.dao;

import java.util.List;

import org.plp.gamification.Antwortmöglichkeit;

public interface AntwortmöglichkeitDAO {
	public void add(Antwortmöglichkeit antwortmöglichkeit);

	public List<Antwortmöglichkeit> listAntwortmöglichkeit();

	public void löschen(int antwortmöglichkeit_id);

	public void update(Antwortmöglichkeit antwortmöglichkeit);

	public Antwortmöglichkeit getAntwortmöglichkeit(int antwortmöglichkeit_id);

	public boolean vorhanden(int antwortmöglichkeit_id);

}
