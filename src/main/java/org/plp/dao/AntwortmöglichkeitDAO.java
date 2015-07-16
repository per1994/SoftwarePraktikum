package org.plp.dao;

import java.util.List;

import org.plp.gamification.Antwortm�glichkeit;

public interface Antwortm�glichkeitDAO {

	public void add(Antwortm�glichkeit antwortm�glichkeit);

	public List<Antwortm�glichkeit> listAntwortm�glichkeiten();

	public void l�schen(int antwortm�glichkeit_id);

	public boolean update(int antwortm�glichkeit_id);

	public Antwortm�glichkeit getAntwortm�glichkeit(int antwortm�glichkeit_id);
}
