package org.plp.gamification;

import java.util.HashSet;
import java.util.Set;

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
import org.plp.gruppenfunktionen.Fachrichtung;

@Entity
@Table(name = "AUFGABE")
public class Aufgabe {

	@Id
	@Column(name = "aufgabe_id")
	@GeneratedValue
	private int aufgabe_id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer aufgabenAutor;

	private Set<Teilaufgabe> teilAufgaben;

	@Column(name = "punktzahl")
	private int punktzahl;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fachrichtung_id")
	private Fachrichtung fachrichtung;

	@Column(name = "themengebiet")
	private String themengebiet;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "aufgabensammlung_id")
	private Aufgabensammlung aufgabenSammlung;

	public Aufgabe() {
		teilAufgaben = new HashSet<Teilaufgabe>();
	}

	public Benutzer getAufgabenAutor() {
		return aufgabenAutor;
	}

	public void setAufgabenAutor(Benutzer aufgabenAutor) {
		this.aufgabenAutor = aufgabenAutor;
	}

	public Set<Teilaufgabe> getTeilAufgaben() {
		return teilAufgaben;
	}

	public void setTeilAufgaben(HashSet<Teilaufgabe> teilAufgaben) {
		this.teilAufgaben = teilAufgaben;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public String getThemengebiet() {
		return themengebiet;
	}

	public void setThemengebiet(String themengebiet) {
		this.themengebiet = themengebiet;
	}

}
