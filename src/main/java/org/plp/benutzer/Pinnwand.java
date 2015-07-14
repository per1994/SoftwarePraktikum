package org.plp.benutzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PINNWAND")
public class Pinnwand {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	private Set<Eintrag> eintr�ge;

	public Pinnwand() {
		eintr�ge = new HashSet<Eintrag>();
	}

	public Set<Eintrag> getEintr�ge() {
		return eintr�ge;
	}

	public void setEintr�ge(Set<Eintrag> eintr�ge) {
		this.eintr�ge = eintr�ge;
	}

}
