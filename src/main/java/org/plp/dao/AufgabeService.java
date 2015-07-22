package org.plp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.plp.gamification.Aufgabe;
import org.plp.gamification.Teilaufgabe;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AufgabeService {

	
	@Autowired
	FachrichtungService fachrichtungservice;
	
	@Autowired
	BenutzerService benutzerservice;
	
	@Autowired
	TeilaufgabeService teilaufgabenservice;
	
	@Autowired
	private AufgabeDAO aufgabeDAO;

	@Transactional
	public void addNewAufgabe(Aufgabe b) {
		aufgabeDAO.add(b);

	}

	@Transactional
	public List<Aufgabe> listAllAufgabe() {
		return aufgabeDAO.listAufgabe();
	}

	@Transactional
	public void löschen(int aufgabe_id) {
		aufgabeDAO.löschen(aufgabe_id);
	}

	@Transactional
	public void update(Aufgabe aufgabe) {
		aufgabeDAO.update(aufgabe);
	}

	@Transactional
	public Aufgabe getAufgabe(int aufgabe_id) {
		return aufgabeDAO.getAufgabe(aufgabe_id);
	}

	@Transactional
	public boolean vorhanden(int aufgabe_id) {
		return aufgabeDAO.vorhanden(aufgabe_id);
	}
	
	
	
	@Transactional
	public void teilaufgabeErstellen(String frage, Set<String>antwortmöglichkeiten,String lösung, String themengebiet, int autor){
		
		Teilaufgabe teilaufgabe= new Teilaufgabe();
		teilaufgabe.setFrage(frage);
		teilaufgabe.setAntwortmöglichkeiten(antwortmöglichkeiten);
		teilaufgabe.setLösung(lösung);
		teilaufgabe.setThemengebiet(themengebiet);
		teilaufgabe.setAufgabenAutor(benutzerservice.getBenutzer(autor));
		benutzerservice.getBenutzer(autor).getErstellteTeilaufgaben().add(teilaufgabe);
		
		teilaufgabenservice.addNewTeilaufgabe(teilaufgabe);
		
		
	}
	
	@Transactional
	public Aufgabe aufgabeAusFachrichtungErstellen(int fachrichtung){
		Aufgabe aufgabe= new Aufgabe();
		aufgabe.setFachrichtung(fachrichtungservice.getFachrichtung(fachrichtung));
		fachrichtungservice.getFachrichtung(fachrichtung).getAufgaben().add(aufgabe);
		List<Teilaufgabe> teilaufgaben= teilaufgabenservice.listAllTeilaufgabe();
		List<Teilaufgabe> teilaufgabenImFachgebiet= new ArrayList<Teilaufgabe>();
		
		for (Teilaufgabe t: teilaufgaben){
			if(t.getFachrichtung().getName().equals(fachrichtungservice.getFachrichtung(fachrichtung).getName())){
				teilaufgabenImFachgebiet.add(t);
				
			}
		}
		
		while (aufgabe.getTeilAufgaben().size()<5){
			int zufallszahl = (int) ((Math.random()*teilaufgabenImFachgebiet.size()));
			Teilaufgabe t= teilaufgabenImFachgebiet.get(zufallszahl);
			
			if(!aufgabe.getTeilAufgaben().contains(t)){
				aufgabe.getTeilAufgaben().add(t);
				t.getAufgaben().add(aufgabe);
			}
			
		}
		
		
		this.addNewAufgabe(aufgabe);
		return aufgabe;
		
	}
	
	public void aufgabeKorrigieren(){
		
	}
	
}
