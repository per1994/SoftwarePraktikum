package org.plp.benutzer;

import java.util.ArrayList;
import java.util.Set;

public class Mediathek {
	
	private Set<Datei> set;
	
	public void dateiHinzuf�gen(Datei datei){
		set.add(datei);
		
	}
	
	public boolean dateil�schen(Datei datei){
		
	if(set.contains(datei)){
		set.remove(datei);
		
		return true;
	}else{
		return false;
	}
		
	}

	public Set<Datei> getSet() {
		return set;
	}

	public void setSet(Set<Datei> set) {
		this.set = set;
	}

}
