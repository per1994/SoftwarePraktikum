package org.plp.gruppenfunktionen;

import org.plp.benutzer.*;
import org.plp.grundfunktionen.Nachricht;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPPE")
public class Gruppe {

	@Id
	@Column(name = "gruppe_id")
	@GeneratedValue
	private int gruppe_id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPPE_MITGLIED", joinColumns = @JoinColumn(name = "gruppe_id"), inverseJoinColumns = @JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> mitgliederListe;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPPE_MODERATOR", joinColumns = @JoinColumn(name = "gruppe_id"), inverseJoinColumns = @JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> moderatorenListe;

	private int anzahlMitglieder;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fachrichtung_id")
	private Fachrichtung fachrichtung;

	private double lernfortschritt;

	private String gruppenName;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Nachricht> nachrichten;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Lernziel> lernziele;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "mediathek_id")
	private Mediathek mediathek;

	public Gruppe() {
		mitgliederListe = new HashSet<Benutzer>();
		moderatorenListe = new HashSet<Benutzer>();
		lernziele = new HashSet<Lernziel>();
	}

	public int getGruppe_id() {
		return gruppe_id;
	}

	public void setGruppe_id(int gruppe_id) {
		this.gruppe_id = gruppe_id;
	}

	public Set<Benutzer> getMitgliederListe() {
		return mitgliederListe;
	}

	public void setMitgliederListe(Set<Benutzer> mitgliederListe) {
		this.mitgliederListe = mitgliederListe;
	}

	public Set<Benutzer> getModeratorenListe() {
		return moderatorenListe;
	}

	public void setModeratorenListe(Set<Benutzer> moderatorenListe) {
		this.moderatorenListe = moderatorenListe;
	}

	public int getAnzahlMitglieder() {
		return anzahlMitglieder;
	}

	public void setAnzahlMitglieder(int anzahlMitglieder) {
		this.anzahlMitglieder = anzahlMitglieder;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public double getLernfortschritt() {
		return lernfortschritt;
	}

	public void setLernfortschritt(double lernfortschritt) {
		this.lernfortschritt = lernfortschritt;
	}

	public String getGruppenName() {
		return gruppenName;
	}

	public void setGruppenName(String gruppenName) {
		this.gruppenName = gruppenName;
	}

	public Set<Lernziel> getLernziele() {
		return lernziele;
	}

	public void setLernziele(Set<Lernziel> lernziele) {
		this.lernziele = lernziele;
	}

	public Mediathek getMediathek() {
		return mediathek;
	}

	public void setMediathek(Mediathek mediathek) {
		this.mediathek = mediathek;
	}

}
