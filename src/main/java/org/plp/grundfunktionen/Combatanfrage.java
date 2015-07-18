package org.plp.grundfunktionen;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.plp.dao.BenutzerService;
import org.plp.dao.CombatService;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="Nachricht")
@DiscriminatorValue("Combatanfrage")
public class Combatanfrage extends Nachricht{
	
	@Transient
	@Autowired
	BenutzerService benutzerservice;
	
	@Transient
	@Autowired
	CombatService combatservice;
	
	
	public Combatanfrage(int sender, int empf�nger,
			int anhang, boolean bearbeitet, boolean statisch){
		
		this.setEmpf�nger(empf�nger);
		this.setSender(sender);
		this.setAnhang(anhang);
		this.setBearbeitet(bearbeitet);
		this.setStatisch(statisch);
		
		String inhalt1;
		inhalt1=benutzerservice.getBenutzer(sender).getVorname() + " "
				+"will dich zu einem Combat im Fachgebiet"+""+combatservice.getCombat(anhang).getAufgabe().getThemengebiet()+" herausfordern";
		this.setInhalt(inhalt1);  
		
		
	}
	
	
	
	
	

}
