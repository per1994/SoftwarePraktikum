package org.plp.grundfunktionen;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.plp.dao.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Nachricht")
@DiscriminatorValue("PinnwandEintrag")
public class PinnwandEintragErhalten extends Nachricht {

	@Autowired
	BenutzerService benutzerservice;

	public PinnwandEintragErhalten(int empfänger, int sender, int anhang,
			boolean bearbeitet, boolean statisch) {

		this.setEmpfänger(empfänger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);

		String inhalt1;
		inhalt1 = benutzerservice.getBenutzer(sender).getVorname() + " "
				+ benutzerservice.getBenutzer(sender).getNachname()
				+ " hat einen Eintrag auf deiner Pinnwand hinterlassen!";
		this.setInhalt(inhalt1);

	}

}
