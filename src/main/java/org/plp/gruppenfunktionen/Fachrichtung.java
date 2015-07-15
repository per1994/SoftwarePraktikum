package org.plp.gruppenfunktionen;

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
	@Column(name = "fachrichtung_id")
	@GeneratedValue
	private int fachrichtung_id;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fachrichtung")
	private Set<Aufgabe> aufgaben;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
