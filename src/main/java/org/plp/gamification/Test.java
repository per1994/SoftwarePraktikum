package org.plp.gamification;

import org.plp.benutzer.Benutzer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Benutzer benutzer1 = new Benutzer();
		benutzer1.setAnzahlCombats(0);
		benutzer1.setAnzahlNiederlagen(0);
		benutzer1.SetPunktzahl(0);
		benutzer1.setAnzahlSiege(0);

		Benutzer benutzer2 = new Benutzer();
		benutzer2.setAnzahlCombats(0);
		benutzer2.setAnzahlNiederlagen(0);
		benutzer2.SetPunktzahl(0);
		benutzer2.setAnzahlSiege(0);

		Combat combat = new Combat(benutzer1, benutzer2);
		combat.setGewinner(benutzer1);
		combat.setVerlierer(benutzer2);
		combat.setPunkteGewinner(5);
		combat.setPunkteVerlierer(2);
		combat.updateBenutzerZahlen();
		combat.updateBenutzerZahlen();

		System.out.println("Punktzahl" + benutzer1.getPunktzahl()
				+ " Anzahl Siege:" + benutzer1.getAnzahlSiege()
				+ " Anzahl Niederlagen:" + benutzer1.getAnzahlNiederlagen()
				+ "Anzahl Combats:" + benutzer1.getAnzahlCombats());
		System.out.println("Punktzahl" + benutzer2.getPunktzahl()
				+ " Anzahl Siege:" + benutzer2.getAnzahlSiege()
				+ " Anzahl Niederlagen:" + benutzer2.getAnzahlNiederlagen()
				+ "Anzahl Combats:" + benutzer2.getAnzahlCombats());
	}

}
