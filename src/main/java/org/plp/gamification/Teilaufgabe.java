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
import javax.persistence.ManyToOne;
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
	
	@Column(name="bearbeitet")
	private boolean bearbeitet;
	
	@Column(name="richtig")
	private boolean richtig;
	
	
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name="FRAGE_ANTWORTMOEGLICHKEITEN", joinColumns=@JoinColumn(name="teilaufgabe_id"))
	private Set<String>antwortm�glichkeiten;
	
	@Column(name="l�sung")
	private String l�sung;
	
	@Column(name="gew�hlteL�sung")
	private String gew�hlteL�sung;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy= "teilAufgabe")
//	private Set<Antwortm�glichkeit> antwortM�glichkeiten;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="aufgabe_id")
	private Aufgabe aufgabe;
	
	
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

//	public Set<Antwortm�glichkeit> getAntwortM�glichkeiten() {
//		return antwortM�glichkeiten;
//	}
//
//	public void setAntwortM�glichkeiten(Set<Antwortm�glichkeit> antwortM�glichkeiten) {
//		this.antwortM�glichkeiten = antwortM�glichkeiten;
//	}

	

	public int getTeilaufgabe_id() {
		return teilaufgabe_id;
	}

	public void setTeilaufgabe_id(int teilaufgabe_id) {
		this.teilaufgabe_id = teilaufgabe_id;
	}

	public Aufgabe getAufgabe() {
		return aufgabe;
	}

	public void setAufgabe(Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
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

}
