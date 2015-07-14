package org.plp.benutzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PINNWAND")
public class Pinnwand {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

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

}
