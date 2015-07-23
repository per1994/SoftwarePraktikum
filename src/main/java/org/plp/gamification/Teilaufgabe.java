package org.plp.gamification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.plp.benutzer.Benutzer;
import org.plp.gruppenfunktionen.Fachrichtung;

@Entity
@Table(name = "TEILAUFGABE")
public class Teilaufgabe {

	@Id
	@Column(name = "teilaufgabe_id")
	@GeneratedValue
	private int teilaufgabe_id;

	@Column(name = "frage")
	private String frage;

	@Column(name = "themengebiet")
	private String themengebiet;

	@Column(name = "bearbeitet")
	private boolean bearbeitet;

	@Column(name = "richtig")
	private boolean richtig;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fachrichtung_id")
	private Fachrichtung fachrichtung;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer aufgabenAutor;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "FRAGE_ANTWORTMOEGLICHKEITEN", joinColumns = @JoinColumn(name = "teilaufgabe_id"))
	private Set<String> antwortmoeglichkeiten;

	@Column(name = "lösung")
	private String loesung;

	@Column(name = "gewählteLösung")
	private String gewaehlteLoesung;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teilAufgaben")
	private Set<Aufgabe> aufgaben;

	public void teilaufgabeKorrigieren() {
		if (gewaehlteLoesung.equals(loesung)) {
			richtig = true;
		} else {
			richtig = false;
		}
	}

	public Teilaufgabe() {
		antwortmoeglichkeiten = new HashSet<String>();
	}

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public int getTeilaufgabe_id() {
		return teilaufgabe_id;
	}

	public void setTeilaufgabe_id(int teilaufgabe_id) {
		this.teilaufgabe_id = teilaufgabe_id;
	}

	public boolean isBearbeitet() {
		return bearbeitet;
	}

	public void setBearbeitet(boolean bearbeitet) {
		this.bearbeitet = bearbeitet;
	}

	public boolean isRichtig() {
		return richtig;
	}

	public void setRichtig(boolean richtig) {
		this.richtig = richtig;
	}

	public String getThemengebiet() {
		return themengebiet;
	}

	public void setThemengebiet(String themengebiet) {
		this.themengebiet = themengebiet;
	}

	public Set<String> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}

	public void setAntwortmoeglichkeiten(Set<String> antwortmöglichkeiten) {
		this.antwortmoeglichkeiten = antwortmöglichkeiten;
	}

	public String getLoesung() {
		return loesung;
	}

	public void setLoesung(String lösung) {
		this.loesung = lösung;
	}

	public String getGewaehlteLoesung() {
		return gewaehlteLoesung;
	}

	public void setGewaehlteLoesung(String gewählteLösung) {
		this.gewaehlteLoesung = gewählteLösung;
	}

	public Set<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(Set<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public Benutzer getAufgabenAutor() {
		return aufgabenAutor;
	}

	public void setAufgabenAutor(Benutzer aufgabenAutor) {
		this.aufgabenAutor = aufgabenAutor;
	}

}
