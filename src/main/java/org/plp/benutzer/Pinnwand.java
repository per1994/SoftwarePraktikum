package org.plp.benutzer;

import java.util.ArrayList;

public class Pinnwand {

	private ArrayList<Eintrag> eintr�ge;

	public Pinnwand() {
		eintr�ge = new ArrayList();
	}

	public ArrayList<Eintrag> getEintr�ge() {
		return eintr�ge;
	}

	public void setEintr�ge(ArrayList<Eintrag> eintr�ge) {
		this.eintr�ge = eintr�ge;
	}

}
