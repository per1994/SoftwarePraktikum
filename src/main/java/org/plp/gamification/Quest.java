package org.plp.gamification;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.plp.benutzer.Benutzer;

@Entity
@Table(name = "QUEST")
public class Quest {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	private HashSet<Aufgabe> aufgaben = new HashSet<Aufgabe>();
	
	private Benutzer questAutor;
	
	@Column(name = "bearbeitungsZeit")
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
