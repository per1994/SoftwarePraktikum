package org.plp.gamification;

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
@Table(name = "ANTWORTMÖGLICHKEIT")
public class Antwortmöglichkeit {

	@Id
	@Column(name = "antwortmöglichkeiten_id")
	@GeneratedValue
	private int antwortmöglichkeit_id;

	@Column(name = "antwortenText")
	private String antwortenText;

	@Column(name = "richtig")
	private boolean richtig;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "teilaufgabe_id")
	private Teilaufgabe teilAufgabe;

	public Antwortmöglichkeit() {

	}

	public int getAntwortmoeglichkeit_id() {
		return antwortmöglichkeit_id;
	}

	public void setAntwortmoeglichkeit_id(int antwortmoeglichkeit_id) {
		this.antwortmöglichkeit_id = antwortmoeglichkeit_id;
	}

	public String getAntwortenText() {
		return antwortenText;
	}

	public void setAntwortenText(String antwortenText) {
		this.antwortenText = antwortenText;
	}

	public boolean isRichtig() {
		return richtig;
	}

	public void setRichtig(boolean richtig) {
		this.richtig = richtig;
	}

	public Teilaufgabe getTeilAufgabe() {
		return teilAufgabe;
	}

	public void setTeilAufgabe(Teilaufgabe teilAufgabe) {
		this.teilAufgabe = teilAufgabe;
	}

}
