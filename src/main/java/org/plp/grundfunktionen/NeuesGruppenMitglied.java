package org.plp.grundfunktionen;

import org.plp.dao.BenutzerService;
import org.plp.dao.GruppeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NeuesGruppenMitglied extends Nachricht {

	@Autowired
	BenutzerService benutzerservice;

	@Autowired
	GruppeService gruppeservice;

	public NeuesGruppenMitglied(int empf�nger, int sender, int anhang,
			boolean bearbeitet, boolean statisch) {

		this.setEmpf�nger(empf�nger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);

		String inhalt1;

		inhalt1 = benutzerservice.getBenutzer(sender).getBenutzerName()
				+ " ist deiner Gruppe " + gruppeservice.getGruppe(empf�nger)
				+ " beigetreten";
		this.setInhalt(inhalt1);
	}
}
