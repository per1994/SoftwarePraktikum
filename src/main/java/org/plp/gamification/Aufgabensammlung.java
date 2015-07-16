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
import javax.persistence.Transient;

@Entity
@Table(name = "AUFGABENSAMMLUNG")
public class Aufgabensammlung {

	@Id
	@Column(name = "aufgabensammlung_id")
	@GeneratedValue
	private int aufgabensammlung_id;

	@Transient
	private Set<Aufgabe> aufgaben;

	public Aufgabensammlung() {
		aufgaben = new HashSet<Aufgabe>();
	}

	public int getAufgabensammlung_id() {
		return aufgabensammlung_id;
	}

	public void setAufgabensammlung_id(int aufgabensammlung_id) {
		this.aufgabensammlung_id = aufgabensammlung_id;
	}

	public Set<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(Set<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

}
