package org.plp.gruppenfunktionen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FACHRICHTUNG")
public class Fachrichtung {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
