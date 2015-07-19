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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BADGE")
public class Badge {

	@Id
	@Column(name = "badge_id")
	@GeneratedValue
	private int badge_id;

	@Column(name = "name")
	private String name;

	@Column(name = "benötigtePunkte")
	private int benötigtePunkte;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "badge")
	private Set<Benutzer> besitzer;
	
	public Badge() {
		besitzer=new HashSet<Benutzer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return badge_id;
	}

	public void setId(int badge_id) {
		this.badge_id = badge_id;
	}

	public int getBenötigtePunkte() {
		return benötigtePunkte;
	}

	public void setBenötigtePunkte(int benötigtePunkte) {
		this.benötigtePunkte = benötigtePunkte;
	}

	public int getBadge_id() {
		return badge_id;
	}

	public void setBadge_id(int badge_id) {
		this.badge_id = badge_id;
	}

	public Set<Benutzer> getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Set<Benutzer> besitzer) {
		this.besitzer = besitzer;
	}

}
