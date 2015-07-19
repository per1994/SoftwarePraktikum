package org.plp.gamification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.plp.benutzer.Benutzer;
import org.plp.gruppenfunktionen.Fachrichtung;

@Entity
@Table(name = "AUFGABE")
public class Aufgabe {

	@Id
	@Column(name = "aufgabe_id")
	@GeneratedValue
	private int aufgabe_id;

	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "AUFGABE_TEILAUFGABE", joinColumns = @JoinColumn(name = "aufgabe_id"), inverseJoinColumns = @JoinColumn(name = "teilaufgabe_id"))
	private Set<Teilaufgabe> teilAufgaben;

	
	
	@Column(name = "punktzahl")
	private int punktzahl;

	@ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name = "fachrichtung_id")
	private Fachrichtung fachrichtung;

	@Column(name = "themengebiet")
	private String themengebiet;

	@Transient
	private Aufgabensammlung aufgabenSammlung;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "AUFGABE_TEAMCOMBAT", joinColumns = @JoinColumn(name = "aufgabe_id"), inverseJoinColumns = @JoinColumn(name = "teamcombat_id"))
	private Set<Teamcombat> teamCombats;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "aufgabe")
	private Set<Combat> combats;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "AUFGABE_QUEST", joinColumns = @JoinColumn(name = "aufgabe_id"), inverseJoinColumns = @JoinColumn(name = "quest_id"))
	private Set<Quest> quests;

	public Aufgabe() {
		teilAufgaben = new HashSet<Teilaufgabe>();
		combats = new HashSet<Combat>();
		teamCombats = new HashSet<Teamcombat>();
		quests = new HashSet<Quest>();
	}
	
	
	public Teilaufgabe getNächsteTeilaufgabe(){
		for (Teilaufgabe  t : teilAufgaben){
			
			if (!t.isBearbeitet()){
				t.setBearbeitet(true);
				return t;
			}
			
			
			
		}
		return null;
		
	}
	
	public void korrigiere(){
		int score=0;
		
		for (Teilaufgabe t: teilAufgaben){
			if (t.isRichtig()){
				score++;
			}
		}
		
		this.punktzahl=score;
		
		
		
	}
	
	
	

	

	public Set<Teilaufgabe> getTeilAufgaben() {
		return teilAufgaben;
	}

	public void setTeilAufgaben(HashSet<Teilaufgabe> teilAufgaben) {
		this.teilAufgaben = teilAufgaben;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public String getThemengebiet() {
		return themengebiet;
	}

	public void setThemengebiet(String themengebiet) {
		this.themengebiet = themengebiet;
	}

	public int getAufgabe_id() {
		return aufgabe_id;
	}

	public void setAufgabe_id(int aufgabe_id) {
		this.aufgabe_id = aufgabe_id;
	}

	public Aufgabensammlung getAufgabenSammlung() {
		return aufgabenSammlung;
	}

	public void setAufgabenSammlung(Aufgabensammlung aufgabenSammlung) {
		this.aufgabenSammlung = aufgabenSammlung;
	}

	public Set<Teamcombat> getTeamCombats() {
		return teamCombats;
	}

	public void setTeamCombats(Set<Teamcombat> teamCombats) {
		this.teamCombats = teamCombats;
	}

	public Set<Combat> getCombats() {
		return combats;
	}

	public void setCombats(Set<Combat> combats) {
		this.combats = combats;
	}

	public Set<Quest> getQuests() {
		return quests;
	}

	public void setQuests(Set<Quest> quests) {
		this.quests = quests;
	}

	public void setTeilAufgaben(Set<Teilaufgabe> teilAufgaben) {
		this.teilAufgaben = teilAufgaben;
	}

}
