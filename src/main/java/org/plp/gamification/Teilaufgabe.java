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
	private Set<String>antwortmöglichkeiten;
	
	@Column(name="lösung")
	private String lösung;
	
	@Column(name="gewählteLösung")
	private String gewählteLösung;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy= "teilAufgabe")
//	private Set<Antwortmöglichkeit> antwortMöglichkeiten;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="aufgabe_id")
	private Aufgabe aufgabe;
	
	
	public  void teilaufgabeKorrigieren(){
		if (gewählteLösung.equals(lösung)){
			richtig= true;
		}
	}
	
	
	public Teilaufgabe(){
		antwortmöglichkeiten= new HashSet<String>();
	}

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

//	public Set<Antwortmöglichkeit> getAntwortMöglichkeiten() {
//		return antwortMöglichkeiten;
//	}
//
//	public void setAntwortMöglichkeiten(Set<Antwortmöglichkeit> antwortMöglichkeiten) {
//		this.antwortMöglichkeiten = antwortMöglichkeiten;
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
