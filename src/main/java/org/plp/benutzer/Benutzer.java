package org.plp.benutzer;

import java.util.ArrayList;

import org.plp.gamification.Quest;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.plp.gruppenfunktionen.Gruppe;
import org.plp.gruppenfunktionen.Lernziel;
import org.plp.gruppenfunktionen.Moderator;
import org.springframework.ui.Model;

public class Benutzer {
	
	private Profil profil= new Profil();
	private String benutzerName;
	private String passwort;
	private String email;
	private ArrayList freundesliste = new ArrayList();
	//private Moderator moderator= new Moderator();
	private ArrayList gruppenListe= new ArrayList();
	private int anzahlCombats;
	private int anzahlNiederlagen;
	private int anzahlSiege;
	private int anzahlUnentschieden;
	private int anzahlQuest;
	private int id;
	
	public void freundHinzufügen (Benutzer benutzer) throws Exception{
		if (!freundesliste.contains(benutzer)){
			freundesliste.add(benutzer);
			benutzer.getFreundesliste().add(this);
			
		}else{
			throw new Exception("Du hast diesen Benutzer bereits zu deiner Freundesliste hinzugefügt");
		}
		
	}
	
	public void freundEntfernen (Benutzer benutzer) throws Exception{
		if (freundesliste.contains(benutzer)){
			freundesliste.remove(benutzer);
			benutzer.getFreundesliste().remove(this);
			
		}else{
			throw new Exception("Du bist aktuell nicht mit"+" "+benutzer.getProfil().getName()+"befreundet");
		}
	}
	
	public void erstellenEintrag(String eintragstext){
		Eintrag eintrag= new Eintrag();
		eintrag.setEintragstext(eintragstext);
		
		
	}
	
	public void schreibenKommentar(Eintrag eintrag, String kommentar){
		eintrag.getKommentare().add(kommentar);
		
	}
	
	public void erstellenGruppe(Fachrichtung fachrichtung, String name, Lernziel lernziel, String passwort) throws Exception{
		
		Gruppe lerngruppe= new Gruppe();
		
		
			lerngruppe.addMitgliedToMitgliederListe(this);
			lerngruppe.setFachrichtung(fachrichtung);
			lerngruppe.setName(name);
			lerngruppe.setLernziel(lernziel);
			lerngruppe.setPasswort(passwort);
			
			this.getGruppenListe().add(lerngruppe);
			
			
			
		
	}
	
	public void einladenBenutzer(Benutzer sender, Benutzer empfänger){
		
	}
	
	public void annehmenEinladung(){
		
	}
	
	public void ablehnenEinladung(){
		
	}
	
	public void beitretenGruppe(Gruppe gruppe) throws Exception{
		gruppe.addMitgliedToMitgliederListe(this);
		this.getGruppenListe().add(gruppe);
		
	}
	
	public void erstellenQuest(){
		Quest quest = new Quest();
		
	}
	
	public void HinzufügenZuModel(Model model){
		model.addAttribute("userName", this.getProfil().getName());
		model.addAttribute("userPassword", passwort);
	}
	
	
	
	
	
	
	
	
	

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList getFreundesliste() {
		return freundesliste;
	}

	public void setFreundesliste(ArrayList freundesliste) {
		this.freundesliste = freundesliste;
	}

	/*public Moderator getModerator() {
		return moderator;
	}

	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}*/

	public ArrayList getGruppenListe() {
		return gruppenListe;
	}

	public void setGruppenListe(ArrayList gruppenListe) {
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

	

}
