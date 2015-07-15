package org.plp.gamification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANTWORTMÖGLICHKEIT")
public class Antwortmöglichkeit {

	@Column(name = "antwortenText")
	private String antwortenText;

	@Column(name = "richtig")
	private boolean richtig;
	
	
	@Id
	@Column(name = "antwortmoeglichkeiten_id")
	@GeneratedValue
	private int antwortmoeglichkeiten_id;

	public Antwortmöglichkeit() {

	}

}
