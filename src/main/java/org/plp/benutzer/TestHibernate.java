package org.plp.benutzer;

import org.plp.dao.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;

public class TestHibernate {
	
	@Autowired
	private BenutzerService benutzerservice;
	
	
	public static void main (String[]args){
		
		
		
		
		
		
		
		
		
		
	}
	
	public void test(){
		
		
		benutzerservice.addNewBenutzer("BenjoMahenjo");
		benutzerservice.addNewBenutzer("per1994");
		
		System.out.println(benutzerservice.listAllBenutzer().size());
		
	}

}
