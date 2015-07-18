package org.plp.grundfunktionen;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.plp.benutzer.Benutzer;
import org.plp.dao.BenutzerService;
import org.plp.dao.GruppeService;
import org.plp.gruppenfunktionen.Gruppe;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="Nachricht")
@DiscriminatorValue("Gruppeneinladung")
public class Gruppeneinladung extends Nachricht {
	
	@Transient
	@Autowired
	BenutzerService benutzerservice;
	
	@Transient
	@Autowired
	GruppeService gruppenservice;
	

	public Gruppeneinladung(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch) {

		this.setEmpfänger(empfänger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);
		
		String inhalt1;
		inhalt1=benutzerservice.getBenutzer(sender).getVorname() + " "
				+"hat dich in die Gruppe"+""+ gruppenservice.getGruppe(anhang).getGruppenName()+"eingeladen";
		this.setInhalt(inhalt1);  

	}

}
