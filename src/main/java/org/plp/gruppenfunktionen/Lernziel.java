package org.plp.gruppenfunktionen;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Lernziel {

	private String inhalt;
	private Date erstellDatum;
	private Date zielDatum;
	private boolean erreicht;
	private int bearbeitungsZeit;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="gruppe_id")
	private Gruppe gruppe;
	
	public String getInhalt() {
		return inhalt;
	}
	
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	
	public Date getErstellDatum() {
		return erstellDatum;
	}
	
	public void setErstellDatum(Date erstellDatum) {
		this.erstellDatum = erstellDatum;
	}
	
	public Date getZielDatum() {
		return zielDatum;
	}
	
	public void setZielDatum(Date zielDatum) {
		this.zielDatum = zielDatum;
	}
	
	public boolean isErreicht() {
		return erreicht;
	}
	
	public void setErreicht(boolean erreicht) {
		this.erreicht = erreicht;
	}
	
	public int getBearbeitungsZeit() {
		return bearbeitungsZeit;
	}
	
	public void setBearbeitungsZeit(int bearbeitungsZeit) {
		this.bearbeitungsZeit = bearbeitungsZeit;
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

}
