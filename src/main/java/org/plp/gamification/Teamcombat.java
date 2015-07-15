package org.plp.gamification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAMCOMBAT")
public class Teamcombat {

	@Id
	@Column(name = "teamcombat_id")
	@GeneratedValue
	private int teamcombat_id;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "teamCombat")
	private Set<Team> teilnehmer;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teamCombats")
	private Set<Aufgabe> aufgabeliste;

	@Column(name = "punkteGewinner")
	private int punkteGewinner;

	@Column(name = "punkteVerlierer")
	private int punkteVerlierer;

	@Column(name = "punkteUnentschieden")
	private int punkteUnentschieden;

	@Column(name = "unentschieden")
	private boolean unentschieden;

}
