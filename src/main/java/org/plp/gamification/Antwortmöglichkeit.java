package org.plp.gamification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ANTWORTMÖGLICHKEIT")
public class Antwortmöglichkeit {

	@Column(name = "antwortenText")
	private String antwortenText;

	@Column(name = "richtig")
	private boolean richtig;

	public Antwortmöglichkeit() {

	}

}
