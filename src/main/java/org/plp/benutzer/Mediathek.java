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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.plp.gruppenfunktionen.Gruppe;

@Entity
@Table(name = "Mediathek")
public class Mediathek {

	@Id
	@Column(name = "mediathek_id")
	@GeneratedValue
	private int mediathek_id;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="mediathek")
	private Gruppe gruppe;

	
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

	public int getMediathek_id() {
		return mediathek_id;
	}

	public void setMediathek_id(int mediathek_id) {
		this.mediathek_id = mediathek_id;
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

}
