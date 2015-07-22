package org.plp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Badge;
import org.plp.benutzer.Benutzer;
import org.plp.benutzer.Eintrag;
import org.plp.benutzer.Kommentar;
import org.plp.benutzer.Mediathek;
import org.plp.benutzer.Pinnwand;
import org.plp.benutzer.Studiengang;
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
	private StudiengangService studiengangservice;

	@Autowired
	private FachrichtungService fachrichtungService;

	@Autowired
	private MediathekService mediathekService;

	@Autowired
	private GruppeService gruppeService;

	@Autowired
	private BadgeService badgeService;

	@Autowired
	private NachrichtService nachrichtService;

	@Transactional
	public void addNewBenutzer(Benutzer benutzer) {

		benutzerDAO.add(benutzer);

	}

	@Transactional
	public List<Benutzer> listAllBenutzer() {
		return benutzerDAO.listBenutzer();
	}

	@Transactional
	public void löschen(int benutzer_id) {
		benutzerDAO.löschen(benutzer_id);
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
	public void freunschaftsAnfrageVersenden(int sender, int empfänger,
			int anhang) {
		nachrichtengenerator.freundschaftsanfrageErstellen(sender, empfänger,
				anhang, false, false);
	}

	@Transactional
	public void frendschaftsAnfrageAnnehmen(int freundschaftsanfrageNachricht) {
		this.getBenutzer(
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getAnhang())
				.getFreundesListe()
				.add(this.getBenutzer(nachrichtService.getNachricht(
						freundschaftsanfrageNachricht).getEmpfänger()));
		this.getBenutzer(
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getEmpfänger())
				.getFreundesListe()
				.add(this.getBenutzer(nachrichtService.getNachricht(
						freundschaftsanfrageNachricht).getAnhang()));
		nachrichtengenerator.freundschaftsanfrageAngenommenErstllen(
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getEmpfänger(),
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getSender(),
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getEmpfänger(), false, true);
		nachrichtService.getNachricht(freundschaftsanfrageNachricht)
				.setBearbeitet(true);

	}

	@Transactional
	public void eintragErstellen(String eintragsText, int sender,
			int empfänger, int anhang) {
		Eintrag eintrag = new Eintrag();
		System.out.println(this.getBenutzer(sender).getBenutzerName());
		eintrag.setEintragstext(eintragsText);
		eintrag.setAutor(this.getBenutzer(sender));
		this.getBenutzer(sender).getEinträge().add(eintrag);
		eintrag.setPinnwand(this.getBenutzer(empfänger).getPinnwand());
		eintragService.addNewEintrag(eintrag);
		this.getBenutzer(empfänger).getPinnwand().getEintraege().add(eintrag);
		nachrichtengenerator.pinnwandEintragErhaltenErstellen(sender,
				empfänger, anhang, false, true);
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
	public void gruppeErstellen(String gruppenName, String fachrichtungName,
			int ersteller) {
		int fachrichtung_id = 0;
		for (Fachrichtung fachrichtung : fachrichtungService
				.listAllFachrichtung()) {
			if (fachrichtung.getName().equals(fachrichtungName)) {
				fachrichtung_id = fachrichtung.getFachrichtung_id();
			}
				}
		
		if(fachrichtung_id==0){
			Fachrichtung r= new Fachrichtung();
			r.setName(fachrichtungName);
			fachrichtungService.addNewFachrichtung(r);
			fachrichtung_id=r.getFachrichtung_id();
		}

		System.out.println(fachrichtung_id);
		Mediathek mediathek = new Mediathek();
		mediathekService.addNewMediathek(mediathek);
		
		Pinnwand pinnwand= new Pinnwand();
		pinnwandService.addNewPinnwand(pinnwand);
		Gruppe gruppe = new Gruppe();
		gruppe.setFachrichtung(fachrichtungService
				.getFachrichtung(fachrichtung_id));
		fachrichtungService.getFachrichtung(fachrichtung_id).getGruppen().add(gruppe);
		gruppe.setMediathek(mediathek);
		mediathek.setGruppe(gruppe);
		gruppe.setPinnwand(pinnwand);
		pinnwand.setGruppe(gruppe);
		gruppe.setGruppenName(gruppenName);
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
		this.getBenutzer(gruppenEinladung.getEmpfänger()).getGruppenListe()
				.add(gruppeService.getGruppe(gruppenEinladung.getAnhang()));
		gruppeService.getGruppe(gruppenEinladung.getAnhang())
				.getMitgliederListe()
				.add(this.getBenutzer(gruppenEinladung.getEmpfänger()));
		for (Benutzer benutzer : gruppeService.getGruppe(
				gruppenEinladung.getAnhang()).getMitgliederListe()) {
			nachrichtengenerator.gruppenEinladungAngenommenErstellen(
					gruppenEinladung.getEmpfänger(), benutzer.getBenutzer_id(),
					gruppenEinladung.getAnhang(), false, false);
		}

		gruppenEinladung.setBearbeitet(true);
		gruppeService.getGruppe(gruppenEinladung.getAnhang()).setAnzahlMitglieder(gruppeService.getGruppe(gruppenEinladung.getAnhang()).getAnzahlMitglieder()+1);
	}

	@Transactional
	public void freundLöschen(int benutzer, int freund) {

		this.getBenutzer(benutzer).getFreundesListe()
				.remove(this.getBenutzer(freund));
		this.getBenutzer(freund).getFreundesListe()
				.remove(this.getBenutzer(benutzer));
	}

	@Transactional
	public void aufBadgeÜberprüfen(int benutzer) {

		ArrayList<Badge> hilfsListe = new ArrayList<Badge>();
		badgeService.listAllBadge();

		for (Badge badge : badgeService.listAllBadge()) {
			hilfsListe.add(badge);
		}

		Badge temp;
		for (int i = 1; i < hilfsListe.size(); i++) {
			for (int j = 0; j < hilfsListe.size() - i; j++) {
				if (hilfsListe.get(j).getBenötigtePunkte() > hilfsListe.get(
						j + 1).getBenötigtePunkte()) {
					temp = hilfsListe.get(j);
					hilfsListe.set(i, hilfsListe.get(j + 1));
					hilfsListe.set(j + 1, temp);
				}

			}
		}
		int zähler = 0;
		while ((hilfsListe.get(zähler).getBenötigtePunkte() < this.getBenutzer(
				benutzer).getPunktzahl())
				|| (hilfsListe.get(hilfsListe.size() - 1).getBenötigtePunkte() < this
						.getBenutzer(benutzer).getPunktzahl())) {
			zähler = zähler + 1;
		}
		if ((!hilfsListe.get(zähler).equals(
				this.getBenutzer(benutzer).getBadge()))
				&& (!hilfsListe.get(hilfsListe.size() - 1).equals(
						this.getBenutzer(benutzer).getBadge())))
			this.getBenutzer(benutzer).setBadge(hilfsListe.get(zähler));
	}

	@Transactional
	public void registrieren(String benutzername,String vorname, String nachname,
			String studiengang, String tag, String monat, String jahr,
			String passwort, String geschlecht) {
		
		
		List<Studiengang>alleStudiengänge=studiengangservice.listAllStudiengang();
		
		int studiengangid=0;
		for(Studiengang s: alleStudiengänge){
			if(s.getName().equals(studiengang)){
				studiengangid=s.getStudiengang_id();
			}
			
		}
		
		Pinnwand pinnwand = new Pinnwand();
		pinnwandService.addNewPinnwand(pinnwand);
		Benutzer benutzer = new Benutzer();
		benutzer.setVorname(vorname);
		benutzer.setNachname(nachname);
		benutzer.setBenutzerName(benutzername);
		benutzer.setStudiengang(studiengangservice.getStudiengang(studiengangid));
		benutzer.setGebDatum(tag + "." + monat + "." + jahr);
		benutzer.setPasswort(passwort);
		benutzer.setGeschlecht(geschlecht);
		
		pinnwand.setBesitzer(benutzer);
		benutzer.setPinnwand(pinnwand);
		this.addNewBenutzer(benutzer); 
	}

	@Transactional
	public void nachrichtGelesen(int nachricht) {
		nachrichtService.getNachricht(nachricht).setBearbeitet(true);
	}

}
