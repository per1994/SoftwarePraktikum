package org.plp.benutzer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;






import org.plp.gamification.Quest;
import org.plp.grundfunktionen.Nachricht;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.plp.gruppenfunktionen.Gruppe;
import org.plp.gruppenfunktionen.Lernziel;
import org.plp.gruppenfunktionen.Moderator;
import org.springframework.ui.Model;




@Entity
@Table(name = "BENUTZER")
public class Benutzer {

	@Column(name = "benutzerName")
	private String benutzerName;
	
	@Column(name = "vorname")
	private String vorname;
	
	@Column(name = "nachname")
	private String nachname;
	
	@Column(name = "passwort")
	private String passwort;
	private String email;
	
	@Column(name = "email")
	private Set<Benutzer> freundesliste;
	//private Moderator moderator = new Moderator();
	private Set<Gruppe> gruppenListe;
	
	@Column(name = "anzahlCombats")
	private int anzahlCombats;
	
	@Column(name = "anzahlNiederlagen")
	private int anzahlNiederlagen;
	
	@Column(name = "anzahlSiege")
	private int anzahlSiege;
	
	@Column(name = "anzahlUnentschieden")
	private int anzahlUnentschieden;
	
	@Column(name = "anzahlQuest")
	private int anzahlQuest;
	
	@Id
	@Column(name = "erstelltAm")
	@GeneratedValue
	private int id;
	
	@Column(name = "punktzahl")
	private int punktzahl;
	
	@Column(name = "erstelltAm")
	private Pinnwand pinnwand;
	
	@Column(name = "gebDatum")
	private Date gebDatum;

	@Column(name = "geschlecht")
	private char geschlecht;
	private Fachrichtung fachrichtung;
	private Set<Badge> badges;
	private Avatar avatar;
	private Set<Achievement> achievements;
	private Set<Nachricht> nachrichten;

	
	
	public Benutzer() {
		freundesliste = new HashSet<Benutzer>();
		gruppenListe = new HashSet<Gruppe>();
		badges = new HashSet<Badge>();
		achievements = new HashSet<Achievement>();
		nachrichten = new HashSet<Nachricht>();

	}

	public void freundschaftsAnfrageVersenden(Benutzer empf�nger)
			throws Exception {
		if (!freundesliste.contains(empf�nger)) {
			Nachricht nachricht = new Nachricht(this, empf�nger,
					Nachricht.FREUNDSCHAFTSANRAGE, this);
			empf�nger.nachrichten.add(nachricht);
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

	// public void freundHinzuf�gen(Benutzer benutzer) throws Exception {
	// if (!freundesliste.contains(benutzer)) {
	// freundesliste.add(benutzer);
	// benutzer.getFreundesliste().add(this);
	//
	// } else {
	// throw new Exception(
	// "Du hast diesen Benutzer bereits zu deiner Freundesliste hinzugef�gt");
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
			Benutzer empf�nger) {
		Eintrag eintrag = new Eintrag();
		eintrag.setEintragstext(eintragstext);
		pinnwand.getEintr�ge().add(eintrag);
		Nachricht nachricht = new Nachricht(pinnwand, empf�nger,
				Nachricht.PINNWANDEINTRAGERHALTEN, this);
		empf�nger.nachrichten.add(nachricht);
	}

	public void kommentarSchreiben(Eintrag eintrag, String kommentar) {
		eintrag.getKommentare().add(kommentar);

	}

	public void gruppeErstellen(Fachrichtung fachrichtung, String name,
			Lernziel lernziel, String passwort) throws Exception {

		Gruppe lerngruppe = new Gruppe();

		lerngruppe.addMitgliedToMitgliederListe(this);
		lerngruppe.setFachrichtung(fachrichtung);
		lerngruppe.setName(name);
		lerngruppe.setLernziel(lernziel);
		lerngruppe.setPasswort(passwort);

		this.getGruppenListe().add(lerngruppe);

	}

	public void einladenBenutzer(Benutzer empf�nger) {
		Nachricht nachricht = new Nachricht(this, empf�nger,
				Nachricht.FREUNDSCHAFTSANRAGE, this);

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

	public void Hinzuf�genZuModel(Model model) {
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

	/*public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}*/

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

//	public Moderator getModerator() {
//		return moderator;
//	}
//
//	public void setModerator(Moderator moderator) {
//		this.moderator = moderator;
//	}

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
