package org.plp.grundfunktionen;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.plp.benutzer.Benutzer;
import org.plp.dao.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Nachricht")
@DiscriminatorValue("Freunschaftsanfrage")
public class Freundschaftsanfrage extends Nachricht {

	
	
	@Transient
	@Autowired
	BenutzerService benutzerservice;

	public Freundschaftsanfrage(int sender, int empfänger,
			int anhang, boolean bearbeitet, boolean statisch) {

		
		this.setEmpfänger(empfänger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);
		
		/*String inhalt1;
		inhalt1=benutzerservice.getBenutzer(49).getVorname() + " "
				+ benutzerservice.getBenutzer(49).getNachname()
				+ " möchte mit dir befreundet sein!";
		this.setInhalt(inhalt1);  */
		
		

	}
	
	

}
