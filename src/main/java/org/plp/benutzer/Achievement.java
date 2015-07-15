package org.plp.benutzer;

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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ACHIEVEMENT_BESITZER", joinColumns = 
	@JoinColumn(name = "achievement_id"), inverseJoinColumns = 
	@JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> besitzer;

	// Konstruktor für Hibernate
	public Achievement() {
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

}
