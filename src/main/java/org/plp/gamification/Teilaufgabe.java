package org.plp.gamification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy= "teilAufgabe")
	private Set<Antwortmöglichkeit> antwortMöglichkeiten;

	@Column(name = "punktzahl")
	private int punktzahl;

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public Set<Antwortmöglichkeit> getAntwortMöglichkeiten() {
		return antwortMöglichkeiten;
	}

	public void setAntwortMöglichkeiten(Set<Antwortmöglichkeit> antwortMöglichkeiten) {
		this.antwortMöglichkeiten = antwortMöglichkeiten;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

}
