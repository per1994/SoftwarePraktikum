package org.plp.benutzer;

public class Badge {
	
	String name;
	int id;
	int benötigtePunkte;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBenötigtePunkte() {
		return benötigtePunkte;
	}
	public void setBenötigtePunkte(int benötigtePunkte) {
		this.benötigtePunkte = benötigtePunkte;
	}

}
