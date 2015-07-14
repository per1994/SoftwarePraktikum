package org.plp.gamification;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.plp.benutzer.Benutzer;

@Entity
@Table(name = "TEAM")
public class Team {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	private HashSet<Benutzer> teamMitglieder = new HashSet<Benutzer>();
}
