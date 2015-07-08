package org.plp.gruppenfunktionen;

public class Fachrichtung {
	
	private String name;
	private Fakultät fakultät = new Fakultät();
	private int id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Fakultät getFakultät() {
		return fakultät;
	}
	
	public void setFakultät(Fakultät fakultät) {
		this.fakultät = fakultät;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
