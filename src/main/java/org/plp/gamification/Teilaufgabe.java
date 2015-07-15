package org.plp.gamification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEILAUFGABE")
public class Teilaufgabe {

	@Id
	@Column(name = "teilaufgabe_id")
	@GeneratedValue
	private int teilaufgabe_id;

	@Column(name = "frage")
	private String frage;

	private Set<String> antwortMöglichkeiten;

	@Column(name = "punktzahl")
	private int punktzahl;

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public Set<String> getAntwortMöglichkeiten() {
		return antwortMöglichkeiten;
	}

	public void setAntwortMöglichkeiten(HashSet<String> antwortMöglichkeiten) {
		this.antwortMöglichkeiten = antwortMöglichkeiten;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

}
