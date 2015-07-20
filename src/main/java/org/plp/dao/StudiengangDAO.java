package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Studiengang;

public interface StudiengangDAO {
	public void add(Studiengang studiengang);

	public List<Studiengang> listStudiengang();

	public void löschen(int studiengang_id);

	public void update(Studiengang studiengang);

	public Studiengang getStudiengang(int studiengang_id);

	public boolean vorhanden(int studiengang_id);

}
