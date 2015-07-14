package org.plp.benutzer;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EINTRAG")
public class Eintrag {

	@Column(name = "eintragstext")
	private String eintragstext;
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	private Benutzer author;
	
	
	private Set<Kommentar> kommentare;

	public String getEintragstext() {
		return eintragstext;
	}

	public void setEintragstext(String eintragstext) {
		this.eintragstext = eintragstext;
	}

	public Set<Kommentar> getKommentare() {
		return kommentare;
	}

	public void setKommentare(Set<Kommentar> kommentare) {
		this.kommentare = kommentare;
	}

}
