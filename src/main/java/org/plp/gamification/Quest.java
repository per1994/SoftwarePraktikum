package org.plp.gamification;

import java.util.HashSet;

import org.plp.benutzer.Benutzer;

public class Quest {

	private HashSet<Aufgabe> aufgaben = new HashSet<Aufgabe>();
	private Benutzer questAutor;
	private int bearbeitungsZeit;

	
	
	public HashSet<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(HashSet<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public Benutzer getQuestAutor() {
		return questAutor;
	}

	public void setQuestAutor(Benutzer questAutor) {
		this.questAutor = questAutor;
	}

	public int getBearbeitungsZeit() {
		return bearbeitungsZeit;
	}

	public void setBearbeitungsZeit(int bearbeitungsZeit) {
		this.bearbeitungsZeit = bearbeitungsZeit;
	}

}
