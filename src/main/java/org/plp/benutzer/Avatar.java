package org.plp.benutzer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVATAR")
public class Avatar {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "anzahlAchievement")
	private int anzahlAchievement;

	public Avatar() {
	}

	public int getAnzahlAchievement() {
		return anzahlAchievement;
	}

	public void setAnzahlAchievement(int anzahlAchievement) {
		this.anzahlAchievement = anzahlAchievement;
	}

}
