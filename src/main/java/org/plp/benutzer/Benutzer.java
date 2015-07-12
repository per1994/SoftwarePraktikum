package org.plp.benutzer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.plp.gamification.Quest;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.plp.gruppenfunktionen.Gruppe;
import org.plp.gruppenfunktionen.Lernziel;
import org.plp.gruppenfunktionen.Moderator;
import org.springframework.ui.Model;

public class Benutzer {

	
	private String benutzerName;
	private String vorname;
	private String nachname;
	private String passwort;
	private String email;
	private Set freundesliste;
	//private Moderator moderator= new Moderator();
	private Set gruppenListe; 
	private int anzahlCombats;
	private int anzahlNiederlagen;
	private int anzahlSiege;
	private int anzahlUnentschieden;
	private int anzahlQuest;
	private int id;
	private int punktzahl;
	private Pinnwand pinnwand;
	private Date gebDatum;
	private int alter;
	private char geschlecht;
	private Fachrichtung fachrichtung;
	private Set<Badge> badges;
	private Avatar avatar;
	private Set<Achievement> achievements;
	
	public Benutzer(){
		freundesliste= new HashSet();
		gruppenListe= new HashSet();
		badges= new HashSet();
		achievements= new HashSet();
		
	}

	public void freundHinzufügen(Benutzer benutzer) throws Exception {
		if (!freundesliste.contains(benutzer)) {
			freundesliste.add(benutzer);
			benutzer.getFreundesliste().add(this);

		} else {
			throw new Exception(
					"Du hast diesen Benutzer bereits zu deiner Freundesliste hinzugefügt");
		}

	}

	public void freundEntfernen(Benutzer benutzer) throws Exception {
		if (freundesliste.contains(benutzer)) {
			freundesliste.remove(benutzer);
			benutzer.getFreundesliste().remove(this);

		} else {
			throw new Exception("Du bist aktuell nicht mit" + " "
					+ benutzer.getVorname() + "befreundet");
		}
	}

	public void erstellenEintrag(Pinnwand pinnwand,String eintragstext, Benutzer empfänger) {
		Eintrag eintrag = new Eintrag();
		eintrag.setEintragstext(eintragstext);
		pinnwand.getEinträge().add(eintrag);
		pinnwand.setNeueEinträge(pinnwand.getNeueEinträge()+1);
		pinnwand.benachrichtigenEmpfänger(empfänger);
		

	}

	public void schreibenKommentar(Eintrag eintrag, String kommentar) {
		eintrag.getKommentare().add(kommentar);

	}

	public void erstellenGruppe(Fachrichtung fachrichtung, String name,
			Lernziel lernziel, String passwort) throws Exception {

		Gruppe lerngruppe = new Gruppe();

		lerngruppe.addMitgliedToMitgliederListe(this);
		lerngruppe.setFachrichtung(fachrichtung);
		lerngruppe.setName(name);
		lerngruppe.setLernziel(lernziel);
		lerngruppe.setPasswort(passwort);

		this.getGruppenListe().add(lerngruppe);

	}

	public void einladenBenutzer(Benutzer sender, Benutzer empfänger) {

	}

	public void annehmenEinladung() {

	}

	public void ablehnenEinladung() {

	}

	public void beitretenGruppe(Gruppe gruppe) throws Exception {
		gruppe.addMitgliedToMitgliederListe(this);
		this.getGruppenListe().add(gruppe);

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

	public void setFreundesliste(HashSet freundesliste) {
		this.freundesliste = freundesliste;
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

	public void setGruppenListe(HashSet gruppenListe) {
		this.gruppenListe = gruppenListe;
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
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

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

	public void setFreundesliste(Set freundesliste) {
		this.freundesliste = freundesliste;
	}

	public void setGruppenListe(Set gruppenListe) {
		this.gruppenListe = gruppenListe;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

}
