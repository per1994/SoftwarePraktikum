package org.plp.grundfunktionen;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.plp.benutzer.Benutzer;
import org.plp.gamification.Combat;
import org.plp.gruppenfunktionen.Gruppe;

@Entity
@Table(name = "NACHRICHT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="discriminator",
    discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="Nachricht")
public class Nachricht {

	@Id
	@Column(name = "nachricht_id")
	@GeneratedValue
	private int nachricht_id;

	@Column(name="sender")
	private int sender;
	
	@Column(name="empfänger")
	private int empfänger;

	@Column(name="anhang")
	private int anhang;
	
	@Column(name="bearbeitet")
	private boolean bearbeitet;
	
	@Column(name="inhalt")
	private String inhalt;
	
	@Column(name="satisch")
	private boolean statisch;
	
	
	
	public Nachricht(){
		
		
	}
	



	public int getNachricht_id() {
		return nachricht_id;
	}



	public void setNachricht_id(int nachricht_id) {
		this.nachricht_id = nachricht_id;
	}



	public int getSender() {
		return sender;
	}



	public void setSender(int sender) {
		this.sender = sender;
	}



	public int getEmpfänger() {
		return empfänger;
	}



	public void setEmpfänger(int empfänger) {
		this.empfänger = empfänger;
	}



	public int getAnhang() {
		return anhang;
	}



	public void setAnhang(int anhang) {
		this.anhang = anhang;
	}



	public boolean isBearbeitet() {
		return bearbeitet;
	}



	public void setBearbeitet(boolean bearbeitet) {
		this.bearbeitet = bearbeitet;
	}



	public String getInhalt() {
		return inhalt;
	}



	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}




	public boolean isStatisch() {
		return statisch;
	}




	public void setStatisch(boolean statisch) {
		this.statisch = statisch;
	}
	
	

}
