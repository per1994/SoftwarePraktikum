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

@Entity
@Table(name = "PINNWAND")
public class Pinnwand {

	@Id
	@Column(name = "pinnwand_id")
	@GeneratedValue
	private int pinnwand_id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="pinnwand")
	private Benutzer besitzer;

	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy= "pinnwand")
	private Set<Eintrag> einträge;

	public Pinnwand() {
		einträge = new HashSet<Eintrag>();
	}

	public Set<Eintrag> getEinträge() {
		return einträge;
	}

	public void setEinträge(Set<Eintrag> einträge) {
		this.einträge = einträge;
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

}
