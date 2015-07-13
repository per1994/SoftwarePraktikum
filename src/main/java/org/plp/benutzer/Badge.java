package org.plp.benutzer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BADGE")
public class Badge {
	
	
	@Column(name = "name")
	private String name;
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	
	@Column(name = "benötigtePunkte")
	private int benötigtePunkte;
	
	
	public Badge(){}
	
	
	
	
	
	
	
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
