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

	@Column(name = "ben�tigteCombatsiege")
	private int ben�tigteCombatsiege;

	@Column(name = "ben�tigteCombats")
	private int ben�tigteCombats;

	@Column(name = "ben�tigteQuests")
	private int ben�tigteQuests;

	// Konstruktor f�r Hibernate
	public Achievement() {
	}

	public int getBen�tigteCombatsiege() {
		return ben�tigteCombatsiege;
	}

	public void setBen�tigteCombatsiege(int ben�tigteCombatsiege) {
		this.ben�tigteCombatsiege = ben�tigteCombatsiege;
	}

	public int getBen�tigteCombats() {
		return ben�tigteCombats;
	}

	public void setBen�tigteCombats(int ben�tigteCombats) {
		this.ben�tigteCombats = ben�tigteCombats;
	}

	public int getBen�tigteQuests() {
		return ben�tigteQuests;
	}

	public void setBen�tigteQuests(int ben�tigteQuests) {
		this.ben�tigteQuests = ben�tigteQuests;
	}

}
