package org.plp.dao;

import java.util.List;

import org.plp.gamification.Antwortm�glichkeit;

public interface Antwortm�glichkeitDAO {
	public void add(Antwortm�glichkeit antwortm�glichkeit);

	public List<Antwortm�glichkeit> listAntwortm�glichkeit();

	public void l�schen(int antwortm�glichkeit_id);

	public void update(Antwortm�glichkeit antwortm�glichkeit);

	public Antwortm�glichkeit getAntwortm�glichkeit(int antwortm�glichkeit_id);

	public boolean vorhanden(int antwortm�glichkeit_id);

}
