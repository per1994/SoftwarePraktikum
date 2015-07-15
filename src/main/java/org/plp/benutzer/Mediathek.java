package org.plp.benutzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Mediathek")
public class Mediathek {

	@Id
	@Column(name = "mediathek_id")
	@GeneratedValue
	private int mediathek_id;

	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy= "mediathek")
	private Set<Datei> set;

	public Mediathek() {
		set = new HashSet<Datei>();
	}

	public void dateiHinzufügen(Datei datei) {
		set.add(datei);

	}

	public boolean dateilöschen(Datei datei) {

		if (set.contains(datei)) {
			set.remove(datei);

			return true;
		} else {
			return false;
		}

	}

	public Set<Datei> getSet() {
		return set;
	}

	public void setSet(Set<Datei> set) {
		this.set = set;
	}

}
