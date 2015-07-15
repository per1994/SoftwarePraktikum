package org.plp.gamification;

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
@Table(name="AUFGABENSAMMLUNG")
public class Aufgabensammlung {
	
	
	@Id
	@Column(name = "aufgabensammlung_id")
	@GeneratedValue
	private int aufgabensammlung_id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy= "aufgabenSammlung")
	private Set<Aufgabe>aufgaben;

}
