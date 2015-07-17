package org.plp.grundfunktionen;

import org.plp.dao.BenutzerService;
import org.plp.dao.GruppeService;
import org.springframework.beans.factory.annotation.Autowired;

public class CombatAnfrageAngenommen extends Nachricht {

	@Autowired
	BenutzerService benutzerservice;

	public CombatAnfrageAngenommen(int empf�nger, int sender, int anhang,
			boolean bearbeitet, boolean statisch) {

		this.setEmpf�nger(empf�nger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);

		String inhalt1;

		inhalt1 = benutzerservice.getBenutzer(sender).getBenutzerName()
				+ " hat deine Herausforderung zum Combat angenommen";
		this.setInhalt(inhalt1);
	}
}
