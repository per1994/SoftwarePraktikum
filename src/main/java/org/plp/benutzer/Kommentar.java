package org.plp.benutzer;

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
@Table(name = "KOMMENTAR")
public class Kommentar {

	@Id
	@Column(name = "kommentar_id")
	@GeneratedValue
	private int kommentar_id;

	@Column(name = "inhalt")
	private String inhalt;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer author;

	public Kommentar() {

	}
}
