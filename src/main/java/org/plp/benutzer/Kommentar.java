package org.plp.benutzer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "KOMMENTAR")
public class Kommentar {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "inhalt")
	private String inhalt;
	
	
	private Benutzer author;

}
