package org.plp.benutzer;

import java.util.ArrayList;
import java.util.Date;
import org.plp.gruppenfunktionen.Fachrichtung;

public class Profil<T> {

	private Bild profilBild;
	private Pinnwand<T> pinnwand;
	private String name;
	private Date geburtsDatum;
	private int alter;
	private char geschlecht;
	private Fachrichtung fachrichtung;
	private int punkte;
	private ArrayList<T> badges;
	private Avatar avatar;
	private ArrayList<T> achievement;

	public Bild getProfilBild() {
		return profilBild;
	}

	public void setProfilBild(Bild profilBild) {
		this.profilBild = profilBild;
	}

	public Pinnwand<T> getPinnwand() {
		return pinnwand;
	}

	public void setPinnwand(Pinnwand<T> pinnwand) {
		this.pinnwand = pinnwand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ArrayList<T> getBadges() {
		return badges;
	}

	public void setBadges(ArrayList<T> badges) {
		this.badges = badges;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public ArrayList<T> getAchievement() {
		return achievement;
	}

	public void setAchievement(ArrayList<T> achievement) {
		this.achievement = achievement;
	}

	public Date getGeburtsDatum() {
		return geburtsDatum;
	}

	public void setGeburtsDatum(Date geburtsDatum) {
		this.geburtsDatum = geburtsDatum;
	}

}
