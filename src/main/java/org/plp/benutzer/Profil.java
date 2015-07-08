package org.plp.benutzer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.plp.gruppenfunktionen.Fachrichtung;

public class Profil {
	
	private Bild profilbild;
	private Pinnwand pinnwand;
	private String name;
	private GregorianCalendar gebDatum;
	private int alter;
	private char geschlecht;
	private Fachrichtung fachrichtung;
	private int punkte;
	private ArrayList<Badge> badges;
	private Avatar avatar;
	private ArrayList<Achievement> achievements;
	
	public void ändernProfilbild( Bild profilbild){
		this.setProfilbild(profilbild);
	}
	
	public void ändernNutzerdaten(String name, GregorianCalendar gebDatum, int alter,char geschlecht){
		this.name=name;
		this.gebDatum=gebDatum;
		this.alter=alter;
		this.geschlecht=geschlecht;
		
	}
	
	
	
	public Bild getProfilbild() {
		return profilbild;
	}
	public void setProfilbild(Bild profilbild) {
		this.profilbild = profilbild;
	}
	public Pinnwand getPinnwand() {
		return pinnwand;
	}
	public void setPinnwand(Pinnwand pinnwand) {
		this.pinnwand = pinnwand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GregorianCalendar getGebDatum() {
		return gebDatum;
	}
	public void setGebDatum(GregorianCalendar gebDatum) {
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
	public int getPunkte() {
		return punkte;
	}
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	public ArrayList<Badge> getBadges() {
		return badges;
	}
	public void setBadges(ArrayList<Badge> badges) {
		this.badges = badges;
	}
	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	public ArrayList<Achievement> getAchievements() {
		return achievements;
	}
	public void setAchievements(ArrayList<Achievement> achievements) {
		this.achievements = achievements;
	}

}
