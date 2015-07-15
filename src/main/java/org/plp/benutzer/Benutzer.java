package org.plp.benutzer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.plp.gamification.Aufgabe;
import org.plp.gamification.Combat;
import org.plp.gamification.Quest;
import org.plp.gamification.Team;
import org.plp.grundfunktionen.Nachricht;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.plp.gruppenfunktionen.Gruppe;
import org.plp.gruppenfunktionen.Lernziel;
import org.springframework.ui.Model;

@Entity
@Table(name = "BENUTZER")
public class Benutzer {

	@Id
	@Column(name = "benutzer_id")
	@GeneratedValue
	private int benutzer_id;

	@Column(name = "benutzerName")
	private String benutzerName;

	@Column(name = "vorname")
	private String vorname;

	@Column(name = "nachname")
	private String nachname;

	@Column(name = "passwort")
	private String passwort;

	@Column(name = "email")
	private String email;

	private Set<Benutzer> freundesliste;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "mitgliederListe")
	private Set<Gruppe> gruppenListe;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "moderatorenListe")
	private Set<Gruppe> moderierteGruppenListe;

	@Column(name = "anzahlCombats")
	private int anzahlCombats;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "questTeilnehmer")
	private Set<Quest> quests;

	@Column(name = "anzahlNiederlagen")
	private int anzahlNiederlagen;

	@Column(name = "anzahlSiege")
	private int anzahlSiege;

	@Column(name = "anzahlUnentschieden")
	private int anzahlUnentschieden;

	@Column(name = "anzahlQuest")
	private int anzahlQuest;

	@Column(name = "punktzahl")
	private int punktzahl;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "aufgabenAutor")
	private Set<Aufgabe> erstellteAufgaben;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "autor")
	private Set<Eintrag> einträge;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "autor")
	private Set<Kommentar> kommentare;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "pinnwand_id")
	private Pinnwand pinnwand;

	@Column(name = "gebDatum")
	private Date gebDatum;

	@Column(name = "geschlecht")
	private char geschlecht;
	private Fachrichtung fachrichtung;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "besitzer")
	private Set<Badge> badges;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "avatar_id")
	private Avatar avatar;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teamMitgleider")
	private Set<Team> teams;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teilnehmer")
	private Set<Combat> combats;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "besitzer")
	private Set<Achievement> achievements;
	private Set<Nachricht> nachrichten;

	public Benutzer() {
		freundesliste = new HashSet<Benutzer>();
		gruppenListe = new HashSet<Gruppe>();
		badges = new HashSet<Badge>();
		achievements = new HashSet<Achievement>();
		nachrichten = new HashSet<Nachricht>();

	}

	public void freundschaftsAnfrageVersenden(Benutzer empfänger)
			throws Exception {
		if (!freundesliste.contains(empfänger)) {
			Nachricht nachricht = new Nachricht(this, empfänger,
					Nachricht.FREUNDSCHAFTSANRAGE, this);
			empfänger.nachrichten.add(nachricht);
		} else {
			throw new Exception("Du bist bereits mit diesem Nutzer befreundet");
		}
	}

	public void freundschaftsAnfrageAnnehmen(Nachricht freundschaftsAnfrage) {
		this.freundesliste.add((Benutzer) freundschaftsAnfrage.getAnhang());
		((Benutzer) freundschaftsAnfrage.getAnhang()).freundesliste.add(this);
		this.nachrichten.remove(freundschaftsAnfrage);
		Nachricht nachricht = new Nachricht(this,
				freundschaftsAnfrage.getAnhang(),
				Nachricht.FREUNDSCHAFTSANFRAGEANGENOMMEN, this);
		((Benutzer) freundschaftsAnfrage.getAnhang()).nachrichten
				.add(nachricht);
	}

	// public void freundHinzufügen(Benutzer benutzer) throws Exception {
	// if (!freundesliste.contains(benutzer)) {
	// freundesliste.add(benutzer);
	// benutzer.getFreundesliste().add(this);
	//
	// } else {
	// throw new Exception(
	// "Du hast diesen Benutzer bereits zu deiner Freundesliste hinzugefügt");
	// }
	//
	// }

	public void freundEntfernen(Benutzer freund) throws Exception {
		if (freundesliste.contains(freund)) {
			freundesliste.remove(freund);
			freund.getFreundesliste().remove(this);

		} else {
			throw new Exception("Du bist aktuell nicht mit" + " "
					+ freund.getVorname() + "befreundet");
		}
	}

	public void eintragErstellen(Pinnwand pinnwand, String eintragstext,
			Benutzer empfänger) {
		Eintrag eintrag = new Eintrag();
		eintrag.setEintragstext(eintragstext);
		pinnwand.getEinträge().add(eintrag);
		Nachricht nachricht = new Nachricht(pinnwand, empfänger,
				Nachricht.PINNWANDEINTRAGERHALTEN, this);
		empfänger.nachrichten.add(nachricht);
	}

	public void kommentarSchreiben(Eintrag eintrag, Kommentar kommentar) {
		eintrag.getKommentare().add(kommentar);

	}

	public void gruppeErstellen(Fachrichtung fachrichtung, String name,
			Lernziel lernziel, String passwort) throws Exception {

	}

	public void einladenBenutzer(Benutzer empfänger) {
		Nachricht nachricht = new Nachricht(this, empfänger,
				Nachricht.FREUNDSCHAFTSANRAGE, this);

	}

	public void annehmenEinladung() {

	}

	public void ablehnenEinladung() {

	}

	public void beitretenGruppe(Gruppe gruppe) throws Exception {

	}

	public void erstellenQuest() {
		Quest quest = new Quest();

	}

	public void HinzufügenZuModel(Model model) {
		model.addAttribute("userName", this.getVorname());
		model.addAttribute("userPassword", passwort);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getFreundesliste() {
		return freundesliste;
	}

	/*
	 * public Moderator getModerator() { return moderator; }
	 * 
	 * public void setModerator(Moderator moderator) { this.moderator =
	 * moderator; }
	 */

	public Set getGruppenListe() {
		return gruppenListe;
	}

	public int getAnzahlCombats() {
		return anzahlCombats;
	}

	public void setAnzahlCombats(int anzahlCombats) {
		this.anzahlCombats = anzahlCombats;
	}

	public int getAnzahlNiederlagen() {
		return anzahlNiederlagen;
	}

	public void setAnzahlNiederlagen(int anzahlNiederlagen) {
		this.anzahlNiederlagen = anzahlNiederlagen;
	}

	public int getAnzahlSiege() {
		return anzahlSiege;
	}

	public void setAnzahlSiege(int anzahlSiege) {
		this.anzahlSiege = anzahlSiege;
	}

	public int getAnzahlUnentschieden() {
		return anzahlUnentschieden;
	}

	public void setAnzahlUnentschieden(int anzahlUnentschieden) {
		this.anzahlUnentschieden = anzahlUnentschieden;
	}

	public int getAnzahlQuest() {
		return anzahlQuest;
	}

	public void setAnzahlQuest(int anzahlQuest) {
		this.anzahlQuest = anzahlQuest;
	}

	public int getId() {
		return benutzer_id;
	}

	public void setId(int benutzer_id) {
		this.benutzer_id = benutzer_id;
	}

	public String getBenutzerName() {
		return benutzerName;
	}

	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void SetPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Pinnwand getPinnwand() {
		return pinnwand;
	}

	public void setPinnwand(Pinnwand pinnwand) {
		this.pinnwand = pinnwand;
	}

	public Date getGebDatum() {
		return gebDatum;
	}

	public void setGebDatum(Date gebDatum) {
		this.gebDatum = gebDatum;
	}

	/*
	 * public int getAlter() { return alter; }
	 * 
	 * public void setAlter(int alter) { this.alter = alter; }
	 */

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public Set<Badge> getBadges() {
		return badges;
	}

	public void setBadges(Set<Badge> badges) {
		this.badges = badges;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Set<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(Set<Achievement> achievements) {
		this.achievements = achievements;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

	// public Moderator getModerator() {
	// return moderator;
	// }
	//
	// public void setModerator(Moderator moderator) {
	// this.moderator = moderator;
	// }

	public Set<Nachricht> getNachrichten() {
		return nachrichten;
	}

	public void setNachrichten(Set<Nachricht> nachrichten) {
		this.nachrichten = nachrichten;
	}

	public void setFreundesliste(Set<Benutzer> freundesliste) {
		this.freundesliste = freundesliste;
	}

	public void setGruppenListe(Set<Gruppe> gruppenListe) {
		this.gruppenListe = gruppenListe;
	}

}
