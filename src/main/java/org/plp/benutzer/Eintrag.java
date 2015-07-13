package org.plp.benutzer;

import java.util.ArrayList;

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
	
	
	private ArrayList<String> kommentare;

	public String getEintragstext() {
		return eintragstext;
	}

	public void setEintragstext(String eintragstext) {
		this.eintragstext = eintragstext;
	}

	public ArrayList<String> getKommentare() {
		return kommentare;
	}

	public void setKommentare(ArrayList<String> kommentare) {
		this.kommentare = kommentare;
	}

}
