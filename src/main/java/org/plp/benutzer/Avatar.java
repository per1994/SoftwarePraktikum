package org.plp.benutzer;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AVATAR")
public class Avatar {

	@Id
	@Column(name = "avatar_id")
	@GeneratedValue
	private int avatar_id;

	@Column(name = "anzahlAchievement")
	private int anzahlAchievement;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy= "avatar")
	private Set<Benutzer>benutzer;

	public Avatar() {
	}

	public int getAnzahlAchievement() {
		return anzahlAchievement;
	}

	public void setAnzahlAchievement(int anzahlAchievement) {
		this.anzahlAchievement = anzahlAchievement;
	}

}
