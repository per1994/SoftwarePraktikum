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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer autor;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "eintrag")
	private Set<Kommentar> kommentare;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "pinnwand_id")
	private Pinnwand pinnwand;

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

	public int getEintrag_id() {
		return eintrag_id;
	}

	public void setEintrag_id(int eintrag_id) {
		this.eintrag_id = eintrag_id;
	}

	public Benutzer getAutor() {
		return autor;
	}

	public void setAutor(Benutzer autor) {
		this.autor = autor;
	}

	public Pinnwand getPinnwand() {
		return pinnwand;
	}

	public void setPinnwand(Pinnwand pinnwand) {
		this.pinnwand = pinnwand;
	}

}
