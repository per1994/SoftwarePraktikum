package org.plp.benutzer;

import java.util.ArrayList;

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

	private ArrayList<Eintrag> einträge;

	public Pinnwand() {
		einträge = new ArrayList();
	}

	public ArrayList<Eintrag> getEinträge() {
		return einträge;
	}

	public void setEinträge(ArrayList<Eintrag> einträge) {
		this.einträge = einträge;
	}

}
