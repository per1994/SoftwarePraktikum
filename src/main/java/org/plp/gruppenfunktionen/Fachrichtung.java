package org.plp.gruppenfunktionen;

public class Fachrichtung {
	
	private String name;
	private Fakult�t fakult�t = new Fakult�t();
	private int id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Fakult�t getFakult�t() {
		return fakult�t;
	}
	
	public void setFakult�t(Fakult�t fakult�t) {
		this.fakult�t = fakult�t;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
