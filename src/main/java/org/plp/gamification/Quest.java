package org.plp.gamification;

import java.util.HashSet;

import org.plp.benutzer.Benutzer;

public class Quest {

	private HashSet<Aufgabe> aufgaben = new HashSet<Aufgabe>();
	private Benutzer questAutor;
	private int bearbeitungsZeit;

}
