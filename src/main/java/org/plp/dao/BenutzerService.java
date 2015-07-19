package org.plp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Badge;
import org.plp.benutzer.Benutzer;
import org.plp.benutzer.Eintrag;
import org.plp.benutzer.Kommentar;
import org.plp.benutzer.Mediathek;
import org.plp.grundfunktionen.Nachricht;
import org.plp.grundfunktionen.Nachrichtengenerator;
import org.plp.gruppenfunktionen.Fachrichtung;
import org.plp.gruppenfunktionen.Gruppe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenutzerService {

	@Autowired
	private BenutzerDAO benutzerDAO;

	@Autowired
	private Nachrichtengenerator nachrichtengenerator = new Nachrichtengenerator();

	@Autowired
	private CombatService combatService;

	@Autowired
	private PinnwandService pinnwandService;

	@Autowired
	private EintragService eintragService;

	@Autowired
	private KommentarService kommentarService;

	@Autowired
	private FachrichtungService fachrichtungService;

	@Autowired
	private MediathekService mediathekService;

	@Autowired
	private GruppeService gruppeService;

	@Autowired
	private BadgeService badgeService;

	@Transactional
	public void addNewBenutzer(String benutzerName, String vorname,
			String nachname) {

		Benutzer b = new Benutzer(benutzerName);
		b.setVorname(vorname);
		b.setNachname(nachname);
		benutzerDAO.add(b);

	}

	@Transactional
	public List<Benutzer> listAllBenutzer() {
		return benutzerDAO.listBenutzer();
	}

	@Transactional
	public void l�schen(int benutzer_id) {
		benutzerDAO.l�schen(benutzer_id);
	}

	@Transactional
	public void update(Benutzer benutzer) {
		benutzerDAO.update(benutzer);
	}

	@Transactional
	public Benutzer getBenutzer(int benutzer_id) {
		return benutzerDAO.getBenutzer(benutzer_id);
	}

	@Transactional
	public boolean vorhanden(int benutzer_id) {
		return benutzerDAO.vorhanden(benutzer_id);
	}

	@Transactional
	public void freunschaftsAnfrageVersenden(int sender, int empf�nger,
			int anhang) {
		nachrichtengenerator.freundschaftsanfrageErstellen(sender, empf�nger,
				anhang, false, false);
	}

	@Transactional
	public void frendschaftsAnfrageAnnehmen(Nachricht freundschaftsanfrage) {
		this.getBenutzer(freundschaftsanfrage.getAnhang()).getFreundesListe()
				.add(this.getBenutzer(freundschaftsanfrage.getEmpf�nger()));
		this.getBenutzer(freundschaftsanfrage.getEmpf�nger())
				.getFreundesListe()
				.add(this.getBenutzer(freundschaftsanfrage.getAnhang()));
		nachrichtengenerator.freundschaftsanfrageAngenommenErstllen(
				freundschaftsanfrage.getEmpf�nger(),
				freundschaftsanfrage.getSender(),
				freundschaftsanfrage.getEmpf�nger(), false, true);
		freundschaftsanfrage.setBearbeitet(true);

	}

	@Transactional
	public void eintragErstellen(String eintragsText, int sender,
			int empf�nger, int anhang) {
		Eintrag eintrag = new Eintrag();
		eintrag.setEintragstext(eintragsText);
		eintrag.setAutor(this.getBenutzer(sender));
		this.getBenutzer(sender).getEintr�ge().add(eintrag);
		eintrag.setPinnwand(this.getBenutzer(empf�nger).getPinnwand());
		eintragService.addNewEintrag(eintrag);
		this.getBenutzer(empf�nger).getPinnwand().getEintr�ge().add(eintrag);
		nachrichtengenerator.pinnwandEintragErhaltenErstellen(sender,
				empf�nger, anhang, false, true);
	}

	@Transactional
	public void kommentarSchreiben(String eintragsText, int eintrag_id,
			int sender) {
		Kommentar kommentar = new Kommentar();
		kommentar.setInhalt(eintragsText);
		kommentar.setAutor(this.getBenutzer(sender));
		this.getBenutzer(sender).getKommentare().add(kommentar);
		kommentar.setEintrag(eintragService.getEintrag(eintrag_id));
		kommentarService.addNewKommentar(kommentar);
		eintragService.getEintrag(eintrag_id).getKommentare().add(kommentar);
	}

	@Transactional
	public void gruppeErstellen(String gruppenName, int fachrichtung_id,
			int ersteller) {
		Mediathek mediathek = new Mediathek();
		mediathekService.addNewMediathek(mediathek);
		Gruppe gruppe = new Gruppe();
		gruppe.setFachrichtung(fachrichtungService
				.getFachrichtung(fachrichtung_id));
		gruppe.setMediathek(mediathek);
		mediathek.setGruppe(gruppe);
		gruppe.getMitgliederListe().add(this.getBenutzer(ersteller));
		gruppe.getModeratorenListe().add(this.getBenutzer(ersteller));
		gruppe.setAnzahlMitglieder(gruppe.getMitgliederListe().size());
		gruppe.setLernfortschritt(0.0);
		mediathek.setGruppe(gruppe);
		this.getBenutzer(ersteller).getGruppenListe().add(gruppe);
		this.getBenutzer(ersteller).getModerierteGruppenListe().add(gruppe);
	}

	@Transactional
	public void gruppenEinladungAnnhemen(Nachricht gruppenEinladung) {
		this.getBenutzer(gruppenEinladung.getEmpf�nger()).getGruppenListe()
				.add(gruppeService.getGruppe(gruppenEinladung.getAnhang()));
		gruppeService.getGruppe(gruppenEinladung.getAnhang())
				.getMitgliederListe()
				.add(this.getBenutzer(gruppenEinladung.getEmpf�nger()));
		for (Benutzer benutzer : gruppeService.getGruppe(
				gruppenEinladung.getAnhang()).getMitgliederListe()) {
			nachrichtengenerator.gruppenEinladungAngenommenErstellen(
					gruppenEinladung.getEmpf�nger(), benutzer.getBenutzer_id(),
					gruppenEinladung.getAnhang(), false, false);
		}

	}

	@Transactional
	public void freundL�schen(int benutzer, int freund) {

		this.getBenutzer(benutzer).getFreundesListe()
				.remove(this.getBenutzer(freund));
		this.getBenutzer(freund).getFreundesListe()
				.remove(this.getBenutzer(benutzer));
	}

	@Transactional
	public void aufBadge�berpr�fen(int benutzer) {

		List<Badge> badgeListe = badgeService.listAllBadge();
		List benutzerListe = this.listAllBenutzer();

		Badge temp;
		for (int i = 1; i < badgeListe.size(); i++) {
			for (int j = 0; j < badgeListe.size() - i; j++) {
				if (badgeListe.get(j).getBen�tigtePunkte() > badgeListe.get(
						j + 1).getBen�tigtePunkte()) {
					temp = badgeListe.get(j);
					badgeListe.set(i, badgeListe.get(j + 1));
					badgeListe.set(j + 1, temp);

				}

			}
		}

	}
}
