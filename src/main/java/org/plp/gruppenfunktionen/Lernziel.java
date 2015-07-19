package org.plp.gruppenfunktionen;

import java.util.Date;

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
@Table(name = "LERNZIEL")
public class Lernziel {
	
	@Id
	@Column(name = "lernziel_id")
	@GeneratedValue
	private int lernziel_id;


	@Column(name="inhalt")
	private String inhalt;
	
	@Column(name="erstellDatum")
	private String erstellDatum;
	
	@Column(name="zielDatum")
	private String zielDatum;
	
	@Column(name="erreicht")
	private boolean erreicht;

	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="gruppe_id")
	private Gruppe gruppe;
	
	public String getInhalt() {
		return inhalt;
	}
	
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	
	
	
	
	
	public boolean isErreicht() {
		return erreicht;
	}
	
	public void setErreicht(boolean erreicht) {
		this.erreicht = erreicht;
	}
	

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	public int getLernziel_id() {
		return lernziel_id;
	}

	public void setLernziel_id(int lernziel_id) {
		this.lernziel_id = lernziel_id;
	}

	public String getErstellDatum() {
		return erstellDatum;
	}

	public void setErstellDatum(String erstellDatum) {
		this.erstellDatum = erstellDatum;
	}

	public String getZielDatum() {
		return zielDatum;
	}

	public void setZielDatum(String zielDatum) {
		this.zielDatum = zielDatum;
	}

}
