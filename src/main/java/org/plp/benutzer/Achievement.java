package org.plp.benutzer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACHIEVEMENT")
public class Achievement {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "benötigteCombatsiege")
	private int benötigteCombatsiege;

	@Column(name = "benötigteCombats")
	private int benötigteCombats;

	@Column(name = "benötigteQuests")
	private int benötigteQuests;

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
