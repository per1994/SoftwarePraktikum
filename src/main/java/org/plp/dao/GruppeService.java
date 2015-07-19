package org.plp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.plp.benutzer.Benutzer;
import org.plp.gamification.Aufgabe;
import org.plp.gamification.Combat;
import org.plp.grundfunktionen.Nachrichtengenerator;
import org.plp.gruppenfunktionen.Gruppe;
import org.plp.gruppenfunktionen.Lernziel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GruppeService {
	
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
	public void CombatanfrageErstellen(int sender, int empfänger, int gruppe){
		Combat c = new Combat();
		List<Aufgabe> aufgaben= aufgabenservice.listAllAufgabe();
		List<Aufgabe>aufgabenImFachgebiet=new ArrayList<Aufgabe>();
		String gruppeFachrichtungName=this.getGruppe(gruppe).getFachrichtung().getName();
		
		for (Aufgabe a: aufgaben){
			if(a.getFachrichtung().getName().equals(gruppeFachrichtungName)){
				aufgabenImFachgebiet.add(a);
				
			}
		}
		
		int zufallszahl = (int) ((Math.random()*aufgabenImFachgebiet.size()));
		System.out.println(aufgabenImFachgebiet.size());
		System.out.println(zufallszahl);
		Aufgabe aufgabe=aufgabenImFachgebiet.get(zufallszahl);
		c.setAufgabe(aufgabe);
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
