package org.plp.benutzer;

import java.util.ArrayList;

public class Pinnwand {

	private int neueEinträge;
	private ArrayList<Eintrag>einträge;
	
	public Pinnwand (){
		einträge= new ArrayList();
	}
	
	
	public void benachrichtigenEmpfänger(Benutzer empfänger){
		
		
	}
	
	
	
	
	public int getNeueEinträge() {
		return neueEinträge;
	}
	public void setNeueEinträge(int neueEinträge) {
		this.neueEinträge = neueEinträge;
	}
	public ArrayList<Eintrag> getEinträge() {
		return einträge;
	}
	public void setEinträge(ArrayList<Eintrag> einträge) {
		this.einträge = einträge;
	}
	
}
