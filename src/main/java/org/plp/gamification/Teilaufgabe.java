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
	
	@Column(name="themengebiet")
	private String themengebiet;
	
	@Column(name="bearbeitet")
	private boolean bearbeitet;
	
	@Column(name="richtig")
	private boolean richtig;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name = "fachrichtung_id")
	private Fachrichtung fachrichtung;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer aufgabenAutor;
	
	
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name="FRAGE_ANTWORTMOEGLICHKEITEN", joinColumns=@JoinColumn(name="teilaufgabe_id"))
	private Set<String>antwortm�glichkeiten;
	
	@Column(name="l�sung")
	private String l�sung;
	
	@Column(name="gew�hlteL�sung")
	private String gew�hlteL�sung;

	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teilAufgaben")
	private Set<Aufgabe>aufgaben;
	
	
	public  void teilaufgabeKorrigieren(){
		if (gew�hlteL�sung.equals(l�sung)){
			richtig= true;
		}
	}
	
	
	public Teilaufgabe(){
		antwortm�glichkeiten= new HashSet<String>();
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


	public Set<String> getAntwortm�glichkeiten() {
		return antwortm�glichkeiten;
	}


	public void setAntwortm�glichkeiten(Set<String> antwortm�glichkeiten) {
		this.antwortm�glichkeiten = antwortm�glichkeiten;
	}


	public String getL�sung() {
		return l�sung;
	}


	public void setL�sung(String l�sung) {
		this.l�sung = l�sung;
	}


	public String getGew�hlteL�sung() {
		return gew�hlteL�sung;
	}


	public void setGew�hlteL�sung(String gew�hlteL�sung) {
		this.gew�hlteL�sung = gew�hlteL�sung;
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
