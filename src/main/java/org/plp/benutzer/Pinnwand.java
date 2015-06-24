package org.plp.benutzer;

import java.util.ArrayList;

public class Pinnwand<T> {

	private int neueEintraege;
	private ArrayList<T> eintraege;

	public int getNeueEintraege() {
		return neueEintraege;
	}

	public void setNeueEintraege(int neueEintraege) {
		this.neueEintraege = neueEintraege;
	}

	public ArrayList<T> getEintraege() {
		return eintraege;
	}

	public void setEintraege(ArrayList<T> eintraege) {
		this.eintraege = eintraege;
	}
}
