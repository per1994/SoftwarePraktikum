package org.plp.dao;

import java.util.List;

import org.plp.grundfunktionen.Nachricht;

public interface NachrichtDAO {
	public void add(Nachricht nachricht);

	public List<Nachricht> listNachricht();

	public void löschen(int nachricht_id);

	public void update(Nachricht nachricht);

	public Nachricht getNachricht(int nachricht_id);

	public boolean vorhanden(int nachricht_id);

}
