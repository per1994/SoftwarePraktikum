package org.plp.benutzer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDIENGANG")
public class Studiengang {

	@Id
	@Column(name = "studiengang_id", nullable = false, unique = true)
	@GeneratedValue
	private int studiengang_id;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "studiengang")
	private Set<Benutzer> benutzer;

	public Studiengang() {
		benutzer = new HashSet<Benutzer>();
	}

	public int getStudiengang_id() {
		return studiengang_id;
	}

	public void setStudiengang_id(int studiengang_id) {
		this.studiengang_id = studiengang_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Benutzer> getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Set<Benutzer> benutzer) {
		this.benutzer = benutzer;
	}

}
