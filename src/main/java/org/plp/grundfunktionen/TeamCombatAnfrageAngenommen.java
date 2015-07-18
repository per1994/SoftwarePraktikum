package org.plp.grundfunktionen;

import javax.persistence.Transient;

import org.plp.dao.BenutzerService;
import org.plp.dao.GruppeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamCombatAnfrageAngenommen extends Nachricht {

	@Transient
	@Autowired
	BenutzerService benutzerservice;

	@Transient
	@Autowired
	GruppeService gruppeservice;

	public TeamCombatAnfrageAngenommen(int sender, int empfänger, int anhang,
			boolean bearbeitet, boolean statisch) {

		this.setEmpfänger(empfänger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);

		String inhalt1;

		inhalt1 = gruppeservice.getGruppe(sender).getGruppenName()
				+ " hat deine Herausforderung zum Team-Combat angenommen";
		this.setInhalt(inhalt1);
	}
}
