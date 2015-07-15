package org.plp.benutzer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DATEI")
public class Datei {

	@Id
	@Column(name = "datei_id")
	@GeneratedValue
	private int datei_id;

	@Column(name = "pfad")
	private String pfad;

	@Column(name = "name")
	private String name;

	@Column(name = "typ")
	private String typ;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "mediathek_id")
	private Mediathek mediathek;

	public Datei() {

	}

	public String getPfad() {
		return pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getDatei_id() {
		return datei_id;
	}

	public void setDatei_id(int datei_id) {
		this.datei_id = datei_id;
	}

	public Mediathek getMediathek() {
		return mediathek;
	}

	public void setMediathek(Mediathek mediathek) {
		this.mediathek = mediathek;
	}

	
}
