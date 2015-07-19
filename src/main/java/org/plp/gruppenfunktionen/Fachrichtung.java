package org.plp.gruppenfunktionen;

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

import org.plp.gamification.Aufgabe;

@Entity
@Table(name = "FACHRICHTUNG")
public class Fachrichtung {

	@Id
	@Column(name = "fachrichtung_id" ,nullable = false, unique = true)
	@GeneratedValue
	private int fachrichtung_id;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fachrichtung")
	private Set<Aufgabe> aufgaben;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fachrichtung")
	private Set<Gruppe>gruppen;
	
	public Fachrichtung(){
		aufgaben= new HashSet<Aufgabe>();
		gruppen= new HashSet<Gruppe>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFachrichtung_id() {
		return fachrichtung_id;
	}

	public void setFachrichtung_id(int fachrichtung_id) {
		this.fachrichtung_id = fachrichtung_id;
	}

	public Set<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(Set<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public Set<Gruppe> getGruppen() {
		return gruppen;
	}

	public void setGruppen(Set<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}

}
