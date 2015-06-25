package org.plp.gruppenfunktionen;

import java.util.ArrayList;

import org.plp.benutzer.*;

public class Moderator {
	
	private Benutzer benutzer = new Benutzer();
	private ArrayList<Gruppe> gruppenListe = new ArrayList<Gruppe>();
	
	
	public Benutzer getBenutzer() {
		return benutzer;
	}
	
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	
	public ArrayList<Gruppe> getGruppenListe() {
		return gruppenListe;
	}
	
	public void addGruppeToGruppenListe(Gruppe gruppe)throws Exception {
		if(gruppenListe.contains(gruppe)){
			throw new Exception("Gruppe ist bereits in der Liste!");
		}else{
			gruppenListe.add(gruppe);	
		}
	}
	
	public void removeGruppeFromGruppenListe(Gruppe gruppe)throws Exception {
		if(!gruppenListe.contains(gruppe)){
			throw new Exception("Gruppe ist nicht in der Liste!");
		}else{
			gruppenListe.remove(gruppe);	
		}
	}
	
	public void deleteGruppe(Gruppe gruppe){
		gruppenListe.remove(gruppe);
		gruppe = null;
	}
	
	public void deleteMitgliedFromGruppe(Gruppe gruppe, Benutzer mitglied){
		gruppe.getMitgliederListe().remove(mitglied);
	}
	
	public void lernzielFormulieren(Gruppe gruppe, Lernziel ziel){
		gruppe.getLernziele().add(ziel);
	}
	
	public void rolleFestlegen(Gruppe gruppe, Benutzer benutzer){
		Moderator newModerator = new Moderator();
		newModerator.setBenutzer(benutzer);
		newModerator.addGruppeToGruppenListe(gruppe);
		gruppe.getModeratorenListe().add(newModerator);
	}

}
