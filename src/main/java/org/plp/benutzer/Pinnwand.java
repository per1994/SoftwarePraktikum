package org.plp.benutzer;

import java.util.ArrayList;

public class Pinnwand {

	private int neueEintr�ge;
	private ArrayList<Eintrag>eintr�ge;
	
	
	public void benachrichtigenEmpf�nger(Benutzer empf�nger){
		
		
	}
	
	
	
	
	public int getNeueEintr�ge() {
		return neueEintr�ge;
	}
	public void setNeueEintr�ge(int neueEintr�ge) {
		this.neueEintr�ge = neueEintr�ge;
	}
	public ArrayList<Eintrag> getEintr�ge() {
		return eintr�ge;
	}
	public void setEintr�ge(ArrayList<Eintrag> eintr�ge) {
		this.eintr�ge = eintr�ge;
	}
	
}
