package org.plp.benutzer;

import java.util.ArrayList;

import org.plp.gruppenfunktionen.Moderator;

public class Benutzer {
	
	Profil profil= new Profil();
	private String password;
	String email;
	ArrayList freundesliste = new ArrayList();
	Moderator moderator= new Moderator();
	ArrayList gruppenListe= new ArrayList();
	int anzahlCombats;
	int anzahlNiederlagen;
	int anzahlSiege;
	int anzahlUnentschieden;
	int anzahlQuest;
	private int id;
	
	public void freundHinzufügen (Benutzer benutzer) throws Exception{
		if (!freundesliste.contains(benutzer)){
			freundesliste.add(benutzer);
			benutzer.getFreundesliste().add(this);
			
		}else{
			throw new Exception("Du hast diesen Benutzer bereits zu deiner Freundesliste hinzugefügt");
		}
		
	}
	
	public void freundEntfernen (Benutzer benutzer) throws Exception{
		if (freundesliste.contains(benutzer)){
			freundesliste.remove(benutzer);
			
		}else{
			//throw new Exception("Du bist aktuell nicht mit"+" "+benutzer.getProfil().getName()+"befreundet");
		}
	}
	

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList getFreundesliste() {
		return freundesliste;
	}

	public void setFreundesliste(ArrayList freundesliste) {
		this.freundesliste = freundesliste;
	}

	public Moderator getModerator() {
		return moderator;
	}

	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}

	public ArrayList getGruppenListe() {
		return gruppenListe;
	}

	public void setGruppenListe(ArrayList gruppenListe) {
		this.gruppenListe = gruppenListe;
	}

	public int getAnzahlCombats() {
		return anzahlCombats;
	}

	public void setAnzahlCombats(int anzahlCombats) {
		this.anzahlCombats = anzahlCombats;
	}

	public int getAnzahlNiederlagen() {
		return anzahlNiederlagen;
	}

	public void setAnzahlNiederlagen(int anzahlNiederlagen) {
		this.anzahlNiederlagen = anzahlNiederlagen;
	}

	public int getAnzahlSiege() {
		return anzahlSiege;
	}

	public void setAnzahlSiege(int anzahlSiege) {
		this.anzahlSiege = anzahlSiege;
	}

	public int getAnzahlUnentschieden() {
		return anzahlUnentschieden;
	}

	public void setAnzahlUnentschieden(int anzahlUnentschieden) {
		this.anzahlUnentschieden = anzahlUnentschieden;
	}

	public int getAnzahlQuest() {
		return anzahlQuest;
	}

	public void setAnzahlQuest(int anzahlQuest) {
		this.anzahlQuest = anzahlQuest;
	}

	

}
