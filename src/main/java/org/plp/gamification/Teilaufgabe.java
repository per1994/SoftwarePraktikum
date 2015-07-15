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
	private Set<Antwortm�glichkeit> antwortM�glichkeiten;

	@Column(name = "punktzahl")
	private int punktzahl;

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public Set<Antwortm�glichkeit> getAntwortM�glichkeiten() {
		return antwortM�glichkeiten;
	}

	public void setAntwortM�glichkeiten(Set<Antwortm�glichkeit> antwortM�glichkeiten) {
		this.antwortM�glichkeiten = antwortM�glichkeiten;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

}
