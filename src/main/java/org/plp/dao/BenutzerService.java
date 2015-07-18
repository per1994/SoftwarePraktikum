package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Benutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BenutzerService {
	
	@Autowired
	private BenutzerDAO benutzerDAO;
	
	@Transactional
	public void addNewBenutzer(String benutzerName, String vorname, String nachname){
	
		Benutzer b=new Benutzer(benutzerName);
		b.setVorname(vorname);
		b.setNachname(nachname);
		benutzerDAO.add(b);
		
	}
	
	@Transactional
	public List<Benutzer>listAllBenutzer(){
		return benutzerDAO.listBenutzer();
	}
	
	@Transactional
	public void löschen(int benutzer_id){
		benutzerDAO.löschen(benutzer_id);
	}
	
	@Transactional
	public void update( Benutzer benutzer){
		benutzerDAO.update(benutzer);
	}

	@Transactional
	public Benutzer getBenutzer(int benutzer_id){
		return benutzerDAO.getBenutzer(benutzer_id);
	}
	
	@Transactional
	public boolean vorhanden(int benutzer_id){
		return benutzerDAO.vorhanden(benutzer_id);
	}
}
