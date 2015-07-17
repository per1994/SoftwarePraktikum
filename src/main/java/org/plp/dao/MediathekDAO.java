package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Mediathek;

public interface MediathekDAO {
	public void add(Mediathek mediathek);

	public List<Mediathek> listMediathek();

	public void löschen(int mediathek_id);

	public void update(Mediathek mediathek);

	public Mediathek getMediathek(int mediathek_id);

	public boolean vorhanden(int mediathek_id);

}
