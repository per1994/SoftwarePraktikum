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
	public void addNewBenutzer(String benutzerName){
		System.out.println("Ich bin im Service, Methode addNewBenutzer");
		Benutzer b=new Benutzer(benutzerName);
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
	public void update( int benutzer_id){
		benutzerDAO.update(benutzer_id);
	}

}
