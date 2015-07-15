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
	private Set<Aufgabe> aufgabenliste;

	@Column(name = "punkteGewinner")
	private int punkteGewinner;

	@Column(name = "punkteVerlierer")
	private int punkteVerlierer;

	@Column(name = "punkteUnentschieden")
	private int punkteUnentschieden;

	@Column(name = "unentschieden")
	private boolean unentschieden;
	
	public Teamcombat(){
		teilnehmer= new HashSet<Team>();
		aufgabenliste= new HashSet<Aufgabe>();
	}

	public int getTeamcombat_id() {
		return teamcombat_id;
	}

	public void setTeamcombat_id(int teamcombat_id) {
		this.teamcombat_id = teamcombat_id;
	}

	public Set<Team> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(Set<Team> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public Set<Aufgabe> getAufgabeliste() {
		return aufgabenliste;
	}

	public void setAufgabeliste(Set<Aufgabe> aufgabeliste) {
		this.aufgabenliste = aufgabeliste;
	}

	public int getPunkteGewinner() {
		return punkteGewinner;
	}

	public void setPunkteGewinner(int punkteGewinner) {
		this.punkteGewinner = punkteGewinner;
	}

	public int getPunkteVerlierer() {
		return punkteVerlierer;
	}

	public void setPunkteVerlierer(int punkteVerlierer) {
		this.punkteVerlierer = punkteVerlierer;
	}

	public int getPunkteUnentschieden() {
		return punkteUnentschieden;
	}

	public void setPunkteUnentschieden(int punkteUnentschieden) {
		this.punkteUnentschieden = punkteUnentschieden;
	}

	public boolean isUnentschieden() {
		return unentschieden;
	}

	public void setUnentschieden(boolean unentschieden) {
		this.unentschieden = unentschieden;
	}

}
