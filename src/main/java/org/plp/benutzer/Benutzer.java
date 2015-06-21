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
	
	public void freundHinzufügen (Benutzer benutzer){
		freundesliste.add(benutzer);
	}

	

}
