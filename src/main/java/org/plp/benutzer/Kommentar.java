package org.plp.benutzer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KOMMENTAR")
public class Kommentar {

	@Id
	@Column(name = "kommentar_id")
	@GeneratedValue
	private int kommentar_id;

	@Column(name = "inhalt")
	private String inhalt;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer autor;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "eintrag_id")
	private Eintrag eintrag;
	
	public Kommentar() {

	}

	public int getKommentar_id() {
		return kommentar_id;
	}

	public void setKommentar_id(int kommentar_id) {
		this.kommentar_id = kommentar_id;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public Benutzer getAutor() {
		return autor;
	}

	public void setAutor(Benutzer autor) {
		this.autor = autor;
	}

}
