package org.plp.gamification;

import java.util.HashSet;

import org.plp.benutzer.Benutzer;
import org.plp.gruppenfunktionen.Fachrichtung;

public class Aufgabe {

	private Benutzer aufgabenAutor;
	private HashSet<Teilaufgabe> teilAufgaben = new HashSet<Teilaufgabe>();
	private int punktzahl;
	private Fachrichtung fachrichtung;

}
