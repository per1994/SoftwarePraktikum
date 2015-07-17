package org.plp.grundfunktionen;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.plp.dao.GruppeService;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="Nachricht")
@DiscriminatorValue("Teamcombat")
public class Teamcombatanfrage extends Nachricht {
	
	@Autowired
	GruppeService gruppenservice;
	
	public Teamcombatanfrage(int empfänger, int sender,
			int anhang, boolean bearbeitet, boolean statisch){
		
		this.setEmpfänger(empfänger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);
		
		String inhalt1;
		inhalt1="Die Gruppe"+""+gruppenservice.getGruppe(sender).getGruppenName()+"möchte dich zu einem Teamcombat mit dem Fachgebiet"+""+gruppenservice.getGruppe(sender).getFachrichtung().getName()+""+"herausfordern";
		this.setInhalt(inhalt1); 
	}

}
