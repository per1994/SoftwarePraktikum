package org.plp.grundfunktionen;

import org.plp.dao.BenutzerService;
import org.plp.dao.CombatService;
import org.plp.dao.GruppeService;
import org.plp.dao.NachrichtService;
import org.plp.dao.TeamcombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class Nachrichtengenerator {

	@Autowired
	BenutzerService benutzerservice;

	@Autowired
	NachrichtService nachrichtservice;
	
	@Autowired
	CombatService combatservice;
	
	@Autowired
	TeamcombatService teamcombatservice;
	
	@Autowired
	GruppeService gruppenservice;

	public Freundschaftsanfrage ertsellFreundschaftsanfrage(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch) {

		Freundschaftsanfrage f = new Freundschaftsanfrage(sender, empfänger,
				sender, false, false);
		f.setInhalt(benutzerservice.getBenutzer(sender).getVorname() + " "
				+ benutzerservice.getBenutzer(sender).getNachname()
				+ " möchte mit dir befreundet sein!");
		nachrichtservice.addNewNachricht(f);

		return f;

	}
	
	public Gruppeneinladung erstellGruppeneinladung(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch){
		Gruppeneinladung g= new Gruppeneinladung(sender, empfänger,
				sender, bearbeitet, statisch);
		g.setInhalt(benutzerservice.getBenutzer(sender).getVorname() + " "
				+"hat dich in die Gruppe"+""+ gruppenservice.getGruppe(anhang).getGruppenName()+"eingeladen");
		nachrichtservice.addNewNachricht(g);
		
		return g;
	}

	
	public Combatanfrage erstellCombatanfrage(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch){
		Combatanfrage c = new Combatanfrage(sender, empfänger,
				sender, bearbeitet, statisch);
		c.setInhalt(benutzerservice.getBenutzer(sender).getVorname() + " "
				+"will dich zu einem Combat im Fachgebiet"+""+combatservice.getCombat(anhang).getAufgabe().getThemengebiet()+" herausfordern");
		
		return c;
	}
	
	public Teamcombatanfrage erstellTeamcombatanfrage(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch){
		Teamcombatanfrage t= new Teamcombatanfrage(sender, empfänger,
				sender, bearbeitet, statisch);
		t.setInhalt("Die Gruppe"+""+gruppenservice.getGruppe(sender).getGruppenName()+"möchte dich zu einem Teamcombat mit dem Fachgebiet"+""+gruppenservice.getGruppe(sender).getFachrichtung().getName()+""+"herausfordern");
		return t;
	}
	
	public FreundschaftsanfrageAngenommen erstellFreundschaftsanfrageAngenommen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch){
		
		FreundschaftsanfrageAngenommen f= new FreundschaftsanfrageAngenommen(sender, empfänger,
				sender, bearbeitet, statisch);
		f.setInhalt(benutzerservice.getBenutzer(sender).getBenutzerName()
				+ " hat deine Freundschaftsanfrage angenommen" + " beigetreten");
		
		return f;
		
	}
	
	public CombatAnfrageAngenommen erstellCombatAnfrageAngenommen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch){
		
		CombatAnfrageAngenommen c=new CombatAnfrageAngenommen(sender, empfänger,
				sender, bearbeitet, statisch);
		c.setInhalt(benutzerservice.getBenutzer(sender).getBenutzerName()
				+ " hat deine Herausforderung zum Combat angenommen");
		
		return c;
		
	}
	
	public TeamCombatAnfrageAngenommen erstellTeamCombatAnfrageAngenommen(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch){
		
		TeamCombatAnfrageAngenommen t= new TeamCombatAnfrageAngenommen(sender, empfänger,
				sender, bearbeitet, statisch);
		t.setInhalt(gruppenservice.getGruppe(sender).getGruppenName()
				+ " hat deine Herausforderung zum Team-Combat angenommen");
		
		return t;
		
	}
	
	public PinnwandEintragErhalten erstellPinnwandEintragErhalten(int sender,
			int empfänger, int anhang, boolean bearbeitet, boolean statisch){
		
		PinnwandEintragErhalten p= new PinnwandEintragErhalten(sender, empfänger,
				sender, bearbeitet, statisch);
		p.setInhalt(benutzerservice.getBenutzer(sender).getVorname() + " "
				+ benutzerservice.getBenutzer(sender).getNachname()
				+ " hat einen Eintrag auf deiner Pinnwand hinterlassen!");
		
		return p;
		
	}
}
