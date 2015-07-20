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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.plp.dao.BenutzerService;
import org.plp.gamification.Aufgabe;
import org.plp.gamification.Combat;
import org.plp.gamification.Quest;
import org.plp.gamification.Team;
import org.plp.gamification.Teilaufgabe;
import org.plp.grundfunktionen.Nachricht;
import org.plp.grundfunktionen.Nachrichtengenerator;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.plp.gruppenfunktionen.Gruppe;
import org.plp.gruppenfunktionen.Lernziel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Entity
@Table(name = "BENUTZER")
public class Benutzer {

	@Id
	@Column(name = "benutzer_id", nullable = false, unique = true)
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
	private Set<Teilaufgabe> erstellteTeilaufgaben;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "autor")
	private Set<Eintrag> einträge;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "autor")
	private Set<Kommentar> kommentare;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pinnwand_id")
	private Pinnwand pinnwand;

	@Column(name = "gebDatum")
	private String gebDatum;

	@Column(name = "geschlecht")
	private char geschlecht;

	@Column(name = "studiengang")
	private String studiengang;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "badge_id")
	private Badge badge;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "avatar_id")
	private Avatar avatar;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teamMitglieder")
	private Set<Team> teams;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teilnehmer")
	private Set<Combat> combats;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "gewinner")
	private Set<Combat> gewonneneCombats;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "verlierer")
	private Set<Combat> verloreneCombats;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "besitzer")
	private Set<Achievement> achievements;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "BENUTZER_FREUNDE", joinColumns = @JoinColumn(name = "benutzer_id"), inverseJoinColumns = @JoinColumn(name = "freunde_id"))
	private Set<Benutzer> freundesListe;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "freundesListe")
	private Set<Benutzer> freunde;

	public Benutzer() {
		freundesListe = new HashSet<Benutzer>();
		gruppenListe = new HashSet<Gruppe>();
		moderierteGruppenListe = new HashSet<Gruppe>();
		achievements = new HashSet<Achievement>();
		freunde = new HashSet<Benutzer>();
		quests = new HashSet<Quest>();
		erstellteTeilaufgaben = new HashSet<Teilaufgabe>();
		einträge = new HashSet<Eintrag>();
		kommentare = new HashSet<Kommentar>();
		teams = new HashSet<Team>();
		combats = new HashSet<Combat>();

	}

	public Benutzer(String benutzerName) {
		this.benutzerName = benutzerName;
	}

	public void kommentarSchreiben(Eintrag eintrag, Kommentar kommentar) {
		eintrag.getKommentare().add(kommentar);

	}

	public void gruppeErstellen(Fachrichtung fachrichtung, String name,
			Lernziel lernziel, String passwort) throws Exception {

	}

	public void HinzufügenZuModel(Model model) {
		model.addAttribute("userName", this.getVorname());
		model.addAttribute("userPassword", passwort);
	}

	public Set<Gruppe> getGruppenListe() {
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

	public String getGebDatum() {
		return gebDatum;
	}

	public void setGebDatum(String gebDatum) {
		this.gebDatum = gebDatum;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
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

	public void setGruppenListe(Set<Gruppe> gruppenListe) {
		this.gruppenListe = gruppenListe;
	}

	public int getBenutzer_id() {
		return benutzer_id;
	}

	public void setBenutzer_id(int benutzer_id) {
		this.benutzer_id = benutzer_id;
	}

	public Set<Gruppe> getModerierteGruppenListe() {
		return moderierteGruppenListe;
	}

	public void setModerierteGruppenListe(Set<Gruppe> moderierteGruppenListe) {
		this.moderierteGruppenListe = moderierteGruppenListe;
	}

	public Set<Quest> getQuests() {
		return quests;
	}

	public void setQuests(Set<Quest> quests) {
		this.quests = quests;
	}

	public Set<Eintrag> getEinträge() {
		return einträge;
	}

	public void setEinträge(Set<Eintrag> einträge) {
		this.einträge = einträge;
	}

	public Set<Kommentar> getKommentare() {
		return kommentare;
	}

	public void setKommentare(Set<Kommentar> kommentare) {
		this.kommentare = kommentare;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Combat> getCombats() {
		return combats;
	}

	public void setCombats(Set<Combat> combats) {
		this.combats = combats;
	}

	public Set<Benutzer> getFreundesListe() {
		return freundesListe;
	}

	public void setFreundesListe(Set<Benutzer> freundesListe) {
		this.freundesListe = freundesListe;
	}

	public Set<Benutzer> getFreunde() {
		return freunde;
	}

	public void setFreunde(Set<Benutzer> freunde) {
		this.freunde = freunde;
	}

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	public Set<Combat> getGewonneneCombats() {
		return gewonneneCombats;
	}

	public void setGewonneneCombats(Set<Combat> gewonneneCombats) {
		this.gewonneneCombats = gewonneneCombats;
	}

	public Set<Combat> getVerloreneCombats() {
		return verloreneCombats;
	}

	public void setVerloreneCombats(Set<Combat> verloreneCombats) {
		this.verloreneCombats = verloreneCombats;
	}

	public Set<Teilaufgabe> getErstellteTeilaufgaben() {
		return erstellteTeilaufgaben;
	}

	public void setErstellteTeilaufgaben(Set<Teilaufgabe> erstellteTeilaufgaben) {
		this.erstellteTeilaufgaben = erstellteTeilaufgaben;
	}

}
