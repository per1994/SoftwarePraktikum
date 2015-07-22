package org.plp.gamification;

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
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.plp.benutzer.Benutzer;

@Entity
@Table(name = "COMBAT")
public class Combat {

	@Id
	@Column(name = "combat_id")
	@GeneratedValue
	private int combat_id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "COMBAT_TEILNEHMER", joinColumns = @JoinColumn(name = "combat_id"), inverseJoinColumns = @JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> teilnehmer;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "aufgabe_id")
	private Aufgabe aufgabe;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id")
	private Benutzer gewinner;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "benutzer_id", insertable=false, updatable=false)
	private Benutzer verlierer;

	@Column(name = "ersterBenutzer_id")
	private int ersterBenutzer_id;

	@Column(name = "punkteGewinner")
	private int punkteGewinner;

	@Column(name = "punkteVerlierer")
	private int punkteVerlierer;

	@Column(name = "punkteUnentschieden")
	private int punkteUnentschieden;

	@Column(name = "unentschieden")
	private boolean unentschieden;

	@Column(name = "eineAbgabeEingereicht")
	private boolean eineLösungEingereicht;

	@Column(name = "punkteErsteAbgabe")
	private int punkteErsteAbgabe;

	public Combat() {
		teilnehmer = new HashSet<Benutzer>();
	}

	@Transactional
	public void updateBenutzerZahlenKeinUnentschieden() {
		gewinner.SetPunktzahl(gewinner.getPunktzahl() + punkteGewinner);
		gewinner.setAnzahlSiege(gewinner.getAnzahlSiege() + 1);
		verlierer.SetPunktzahl(verlierer.getPunktzahl() + punkteVerlierer);
		verlierer.setAnzahlNiederlagen(verlierer.getAnzahlNiederlagen() + 1);
		for (Benutzer b : teilnehmer) {
			b.setAnzahlCombats(b.getAnzahlCombats() + 1);
		}
	}

//	public void updateBenutzerZahlenUnentschieden() {
//
//		for (Benutzer b : teilnehmer) {
//			b.SetPunktzahl(b.getPunktzahl() + punkteUnentschieden);
//			b.setAnzahlUnentschieden(b.getAnzahlUnentschieden() + 1);
//			b.setAnzahlCombats(b.getAnzahlCombats() + 1);
//			nachrichtengenerator.
//		}
//
//	}

	public Set<Benutzer> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(HashSet<Benutzer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public Aufgabe getAufgabe() {
		return aufgabe;
	}

	public void setAufgabe(Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
	}

	public Benutzer getGewinner() {
		return gewinner;
	}

	public void setGewinner(Benutzer gewinner) {
		this.gewinner = gewinner;
	}

	public Benutzer getVerlierer() {
		return verlierer;
	}

	public void setVerlierer(Benutzer verlierer) {
		this.verlierer = verlierer;
	}

	public int getPunkteGewinner() {
		return punkteGewinner;
	}

	public void setPunkteGewinner(int punkteGewinner) {
		this.punkteGewinner = punkteGewinner;
	}

	public int getPunkteVerlierer() {
		return punkteVerlierer;
	}

	public void setPunkteVerlierer(int punkteVerlierer) {
		this.punkteVerlierer = punkteVerlierer;
	}

	public int getPunkteUnentschieden() {
		return punkteUnentschieden;
	}

	public void setPunkteUnentschieden(int punkteUnentschieden) {
		this.punkteUnentschieden = punkteUnentschieden;
	}

	public boolean isUnentschieden() {
		return unentschieden;
	}

	public void setUnentschieden(boolean unentschieden) {
		this.unentschieden = unentschieden;
	}

	public int getCombat_id() {
		return combat_id;
	}

	public void setCombat_id(int combat_id) {
		this.combat_id = combat_id;
	}

	public void setTeilnehmer(Set<Benutzer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public boolean isEineLösungEingereicht() {
		return eineLösungEingereicht;
	}

	public void setEineLösungEingereicht(boolean eineLösungEingereicht) {
		this.eineLösungEingereicht = eineLösungEingereicht;
	}

	public int getPunkteErsteAbgabe() {
		return punkteErsteAbgabe;
	}

	public void setPunkteErsteAbgabe(int punkteErsteAbgabe) {
		this.punkteErsteAbgabe = punkteErsteAbgabe;
	}

	public int getErsterBenutzer_id() {
		return ersterBenutzer_id;
	}

	public void setErsterBenutzer_id(int ersterBenutzer_id) {
		this.ersterBenutzer_id = ersterBenutzer_id;
	}

}
