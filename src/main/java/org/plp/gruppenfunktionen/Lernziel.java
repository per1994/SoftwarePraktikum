package org.plp.gruppenfunktionen;

import java.util.Date;

public class Lernziel {

	private String inhalt;
	private Date erstellDatum;
	private Date zielDatum;
	private boolean erreicht;
	private int bearbeitungsZeit;
	
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

}
