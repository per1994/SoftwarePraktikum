package org.plp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.plp.gruppenfunktionen.Gruppe;

public interface GruppeDAO {
	public void add(Gruppe gruppe);

	public List<Gruppe> listGruppe();

	public void löschen(int gruppe_id);

	public void update(Gruppe gruppe);

	public Gruppe getGruppe(int gruppe_id);

	public boolean vorhanden(int gruppe_id);

}
