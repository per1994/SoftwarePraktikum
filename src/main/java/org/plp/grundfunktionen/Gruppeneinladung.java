package org.plp.grundfunktionen;

import org.plp.benutzer.Benutzer;
import org.plp.gruppenfunktionen.Gruppe;

public class Gruppeneinladung extends Nachricht {
	
	private Benutzer empf�nger;

	private Gruppe sender;

	private Object anhang_id;

	private String inhalt;
	
	private boolean bearbeitet;

	public Gruppeneinladung(Object empf�nger, Object sender,
			Object anhang_id) {

		this.empf�nger = (Benutzer) empf�nger;
		this.sender = (Gruppe) sender;

		inhalt = "Du wurdest in die Gruppe "
				+ ((Gruppe) sender).getGruppenName() + " eingeladen";

	}

}
