package org.plp.dao;

import java.util.List;

import org.plp.gamification.Antwortmöglichkeit;

public interface AntwortmöglichkeitDAO {

	public void add(Antwortmöglichkeit Antwortmöglichkeit);
	public List<Antwortmöglichkeit> listAntwortmöglichkeit();
	public void löschen(int antwortmöglichkeit_id);
	public boolean update(int antwortmöglichkeit_id);
	public Antwortmöglichkeit getAntwortmöglichkeit(int antwortmöglichkeit_id);
}
