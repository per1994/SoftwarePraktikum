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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EINTRAG")
public class Eintrag {

	@Id
	@Column(name = "eintrag_id")
	@GeneratedValue
	private int eintrag_id;

	@Column(name = "eintragstext")
	private String eintragstext;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer author;

	private Set<Kommentar> kommentare;

	public Eintrag() {
		kommentare = new HashSet<Kommentar>();
	}

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
