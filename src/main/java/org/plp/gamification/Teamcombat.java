package org.plp.gamification;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAMCOMBAT")
public class Teamcombat {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	private HashSet<Team> teilnehmer = new HashSet<Team>();

	private Quest aufgabe;

	@Column(name = "punkteGewinner")
	private int punkteGewinner;

	@Column(name = "punkteVerlierer")
	private int punkteVerlierer;

	@Column(name = "punkteUnentschieden")
	private int punkteUnentschieden;

	@Column(name = "unentschieden")
	private boolean unentschieden;

}
