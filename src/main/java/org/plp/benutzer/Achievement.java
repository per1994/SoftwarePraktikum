package org.plp.benutzer;

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
import javax.persistence.Table;

@Entity
@Table(name = "ACHIEVEMENT")
public class Achievement {

	@Id
	@Column(name = "achievement_id")
	@GeneratedValue
	private int achievement_id;

	@Column(name = "benötigteCombatsiege")
	private int benötigteCombatsiege;

	@Column(name = "benötigteCombats")
	private int benötigteCombats;

	@Column(name = "benötigteQuests")
	private int benötigteQuests;

	@Column(name = "punkteWert")
	private int punkteWert;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ACHIEVEMENT_BESITZER", joinColumns = @JoinColumn(name = "achievement_id"), inverseJoinColumns = @JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> besitzer;

	// Hibernate braucht leeren Konstruktor
	public Achievement() {
		besitzer = new HashSet<Benutzer>();
	}

	public int getBenötigteCombatsiege() {
		return benötigteCombatsiege;
	}

	public void setBenötigteCombatsiege(int benötigteCombatsiege) {
		this.benötigteCombatsiege = benötigteCombatsiege;
	}

	public int getBenötigteCombats() {
		return benötigteCombats;
	}

	public void setBenötigteCombats(int benötigteCombats) {
		this.benötigteCombats = benötigteCombats;
	}

	public int getBenötigteQuests() {
		return benötigteQuests;
	}

	public void setBenötigteQuests(int benötigteQuests) {
		this.benötigteQuests = benötigteQuests;
	}

	public int getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}

	public Set<Benutzer> getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Set<Benutzer> besitzer) {
		this.besitzer = besitzer;
	}

	public int getPunkteWert() {
		return punkteWert;
	}

	public void setPunkteWert(int punkteWert) {
		this.punkteWert = punkteWert;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
