package org.plp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.plp.benutzer.Benutzer;
import org.plp.gamification.Aufgabe;
import org.plp.gamification.Combat;
import org.plp.gamification.Team;
import org.plp.gamification.Teamcombat;
import org.plp.grundfunktionen.Nachrichtengenerator;
import org.plp.gruppenfunktionen.Gruppe;
import org.plp.gruppenfunktionen.Lernziel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GruppeService {
	
	
	@Autowired
	private TeamcombatService teamcombatservice;
	
	@Autowired
	private TeamService teamservice;
	
	@Autowired
	private LernzielService lernzielservice;

	@Autowired
	private BenutzerService benutzerservice;
	
	@Autowired
	private AufgabeService aufgabenservice;
	
	@Autowired
	private CombatService combatservice;
	
	@Autowired
	private Nachrichtengenerator nachrichtengenerator;
	
	@Autowired
	private GruppeDAO gruppeDAO;

	
	@Transactional
	public void combatanfrageErstellen(int sender, int empfänger, int gruppe){
		Combat c = new Combat();
		
		
		c.setAufgabe(this.zufallsaufgabeAusGruppenFachgebietErstellen(gruppe));
		Benutzer b1= benutzerservice.getBenutzer(sender);
		Benutzer b2= benutzerservice.getBenutzer(empfänger);
		
		c.getTeilnehmer().add(b1);
		c.getTeilnehmer().add(b2);
		b1.getCombats().add(c);
		b2.getCombats();
		
		
		
		combatservice.addNewCombat(c);
		List<Combat> combats= combatservice.listAllCombat();
		int combatId=combats.get(combats.size()-1).getCombat_id();
		
		nachrichtengenerator.combatanfrageErstellen(sender, empfänger, combatId, false, false);
		
		
		
		
	}
	
	
	
	@Transactional
	public void benutzerZuGruppeEinladen(int sender, int empfänger, int gruppe){
		
		nachrichtengenerator.gruppeneinladungErstellen(sender, empfänger, gruppe, false, false);
		
		
	}
	
	
	@Transactional
	public void mitgliedAusGruppeEntfernen(int sender, int empfänger, int gruppe){
		Benutzer sender1= benutzerservice.getBenutzer(sender);
		Benutzer empfänger1= benutzerservice.getBenutzer(empfänger);
		Gruppe gruppe1= this.getGruppe(gruppe);
		
		if(gruppe1.getModeratorenListe().contains(sender1)){
			gruppe1.getMitgliederListe().remove(empfänger1);
			empfänger1.getGruppenListe().remove(gruppe1); 
		}
		
	}
	
	
	@Transactional
	public void lernzielFormulieren(int moderator, int gruppe, String inhalt){
		Benutzer moderator1= benutzerservice.getBenutzer(moderator);
		Gruppe gruppe1=this.getGruppe(gruppe);
		
		if(gruppe1.getModeratorenListe().contains(moderator1)){
			Lernziel lernziel= new Lernziel();
			lernziel.setInhalt(inhalt);
			lernziel.setErreicht(false);
			
			lernzielservice.addNewLernziel(lernziel);
			gruppe1.getLernziele().add(lernziel);
			lernziel.setGruppe(gruppe1);
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	@Transactional
	public void teamcombatAnfrageErstellen(int sender, int empfänger){
		Gruppe herausfordererGruppe= this.getGruppe(sender);
		Gruppe gegnerGruppe=this.getGruppe(empfänger);
		
		Teamcombat c= new Teamcombat();
		
		
		
		// Team 1 befüllen
		Team herausforderer= new Team();
		for (int i=0; i<3;i++){
			Benutzer b=herausfordererGruppe.getMitgliederListe().iterator().next();
			if(!herausforderer.getTeamMitglieder().contains(b)){
				herausforderer.getTeamMitglieder().add(b);
				b.getTeams().add(herausforderer);
			}
			
		}
		
		
		// Team 2 befüllen
		Team gegner= new Team();
		for (int i=0; i<3;i++){
			Benutzer b=gegnerGruppe.getMitgliederListe().iterator().next();
			if(!gegner.getTeamMitglieder().contains(b)){
				gegner.getTeamMitglieder().add(b);
				b.getTeams().add(gegner);
			}
			
		}
		// Teams in DB speichern
		teamservice.addNewTeam(herausforderer);
		teamservice.addNewTeam(gegner);
		
		// Aufgabenliste befüllen
		while (c.getAufgabeliste().size()<3){
			Aufgabe a=this.zufallsaufgabeAusGruppenFachgebietErstellen(sender);
			if(!c.getAufgabeliste().contains(a))
			c.getAufgabeliste().add(a);
			
		}
		
		teamcombatservice.addNewTeamcombat(c);
		
		for (Benutzer b: gegner.getTeamMitglieder()){
			nachrichtengenerator.teamcombatanfrageErstellen(sender, b.getBenutzer_id(), c.getTeamcombat_id(), false, false);
			
		}
		
		
		
	}
	
	public Aufgabe zufallsaufgabeAusGruppenFachgebietErstellen(int gruppe){
		
		Aufgabe aufgabe=aufgabenservice.aufgabeAusFachrichtungErstellen(this.getGruppe(gruppe).getFachrichtung().getFachrichtung_id());
		
		return aufgabe;
		
	}
	
	@Transactional
	public void addNewGruppe(Gruppe b) {

		gruppeDAO.add(b);

	}

	@Transactional
	public List<Gruppe> listAllGruppe() {
		return gruppeDAO.listGruppe();
	}

	@Transactional
	public void löschen(int gruppe_id) {
		gruppeDAO.löschen(gruppe_id);
	}

	@Transactional
	public void update(Gruppe gruppe) {
		gruppeDAO.update(gruppe);
	}

	@Transactional
	public Gruppe getGruppe(int gruppe_id) {
		return gruppeDAO.getGruppe(gruppe_id);
	}

	@Transactional
	public boolean vorhanden(int gruppe_id) {
		return gruppeDAO.vorhanden(gruppe_id);
	}
}
