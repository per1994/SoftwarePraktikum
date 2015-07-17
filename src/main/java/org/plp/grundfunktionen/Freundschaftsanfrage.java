package org.plp.grundfunktionen;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.plp.benutzer.Benutzer;
import org.plp.dao.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Nachricht")
@DiscriminatorValue("Freunschaftsanfrage")
public class Freundschaftsanfrage extends Nachricht {

	
	
	@Autowired
	BenutzerService benutzerservice;

	public Freundschaftsanfrage(int empf�nger, int sender,
			int anhang) {

		this.setEmpf�nger(empf�nger);
		this.setSender(sender);
		this.setAnhang(anhang);
		
		String inhalt1;
		inhalt1=benutzerservice.getBenutzer(sender).getVorname() + " "
				+ benutzerservice.getBenutzer(sender).getNachname()
				+ " m�chte mit dir befreundet sein!";
		this.setInhalt(inhalt1);  

	}

}
