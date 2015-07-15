package org.plp.gamification;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.plp.benutzer.Benutzer;

@Entity
@Table(name = "QUEST")
public class Quest {

	@Id
	@Column(name = "quest_id")
	@GeneratedValue
	private int quest_id;

	private HashSet<Aufgabe> aufgaben = new HashSet<Aufgabe>();

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer questTeilnehmer;

	@Column(name = "bearbeitungsZeit")
	private int bearbeitungsZeit;

	public HashSet<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(HashSet<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public Benutzer getQuestAutor() {
		return questTeilnehmer;
	}

	public void setQuestAutor(Benutzer questTeilnehmer) {
		this.questTeilnehmer = questTeilnehmer;
	}

	public int getBearbeitungsZeit() {
		return bearbeitungsZeit;
	}

	public void setBearbeitungsZeit(int bearbeitungsZeit) {
		this.bearbeitungsZeit = bearbeitungsZeit;
	}

}
