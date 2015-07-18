package org.plp.grundfunktionen;

import javax.persistence.Transient;

import org.plp.dao.BenutzerService;
import org.plp.dao.GruppeService;
import org.springframework.beans.factory.annotation.Autowired;

public class FreundschaftsanfrageAngenommen extends Nachricht {

	@Transient
	@Autowired
	BenutzerService benutzerservice;

	public FreundschaftsanfrageAngenommen(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch) {

		this.setEmpfänger(empfänger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);

		String inhalt1;

		inhalt1 = benutzerservice.getBenutzer(sender).getBenutzerName()
				+ " hat deine Freundschaftsanfrage angenommen" + " beigetreten";
		this.setInhalt(inhalt1);
	}
}
