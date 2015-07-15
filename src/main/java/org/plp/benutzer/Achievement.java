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

	@Column(name = "ben�tigteCombatsiege")
	private int ben�tigteCombatsiege;

	@Column(name = "ben�tigteCombats")
	private int ben�tigteCombats;

	@Column(name = "ben�tigteQuests")
	private int ben�tigteQuests;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ACHIEVEMENT_BESITZER", joinColumns = 
	@JoinColumn(name = "achievement_id"), inverseJoinColumns = 
	@JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> besitzer;

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
