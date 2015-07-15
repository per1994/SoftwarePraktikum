package org.plp.gamification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AUFGABENSAMMLUNG")
public class Aufgabensammlung {
	
	
	@Id
	@Column(name = "aufgabensammlung_id")
	@GeneratedValue
	private int aufgabensammlung_id;

}
