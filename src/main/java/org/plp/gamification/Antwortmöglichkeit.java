package org.plp.gamification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ANTWORTM�GLICHKEIT")
public class Antwortm�glichkeit {

	@Column(name = "antwortenText")
	private String antwortenText;

	@Column(name = "richtig")
	private boolean richtig;

	public Antwortm�glichkeit() {

	}

}
