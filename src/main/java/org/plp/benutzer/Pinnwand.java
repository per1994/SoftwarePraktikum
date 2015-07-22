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
@Table(name = "PINNWAND")
public class Pinnwand {

	@Id
	@Column(name = "pinnwand_id", nullable = false, unique = true)
	@GeneratedValue
	private int pinnwand_id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
	mappedBy="pinnwand")
	private Benutzer besitzer;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
			mappedBy="pinnwand")
	private Gruppe gruppe;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pinnwand")
	private Set<Eintrag> eintraege;

	public Pinnwand() {
		eintraege = new HashSet<Eintrag>();
	}

	public Set<Eintrag> getEintraege() {
		if(eintraege == null){
			Set<Eintrag> eintraege = new HashSet<Eintrag>();
			return eintraege;
		} else {
			return eintraege;	
		}
		
	}

	public void setEintraege(Set<Eintrag> einträge) {
		this.eintraege = einträge;
	}

	public int getPinnwand_id() {
		return pinnwand_id;
	}

	public void setPinnwand_id(int pinnwand_id) {
		this.pinnwand_id = pinnwand_id;
	}

	public Benutzer getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Benutzer besitzer) {
		this.besitzer = besitzer;
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	

}
