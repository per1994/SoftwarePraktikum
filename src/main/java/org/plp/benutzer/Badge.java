package org.plp.benutzer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Column(name = "ben�tigtePunkte")
	private int ben�tigtePunkte;

	public Badge() {
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

	public int getBen�tigtePunkte() {
		return ben�tigtePunkte;
	}

	public void setBen�tigtePunkte(int ben�tigtePunkte) {
		this.ben�tigtePunkte = ben�tigtePunkte;
	}

}
