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
	public void frendschaftsAnfrageAnnehmen(int freundschaftsanfrageNachricht) {
		this.getBenutzer(
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getAnhang())
				.getFreundesListe()
				.add(this.getBenutzer(nachrichtService.getNachricht(
						freundschaftsanfrageNachricht).getEmpf�nger()));
		this.getBenutzer(
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getEmpf�nger())
				.getFreundesListe()
				.add(this.getBenutzer(nachrichtService.getNachricht(
						freundschaftsanfrageNachricht).getAnhang()));
		nachrichtengenerator.freundschaftsanfrageAngenommenErstllen(
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getEmpf�nger(),
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getSender(),
				nachrichtService.getNachricht(freundschaftsanfrageNachricht)
						.getEmpf�nger(), false, true);
		nachrichtService.getNachricht(freundschaftsanfrageNachricht)
				.setBearbeitet(true);

	}

	@Transactional
	public void eintragErstellen(String eintragsText, int sender,
			int empf�nger, int anhang) {
		Eintrag eintrag = new Eintrag();
		System.out.println(this.getBenutzer(sender).getBenutzerName());
		eintrag.setEintragstext(eintragsText);
		eintrag.setAutor(this.getBenutzer(sender));
		this.getBenutzer(sender).getEintr�ge().add(eintrag);
		eintrag.setPinnwand(this.getBenutzer(empf�nger).getPinnwand());
		eintragService.addNewEintrag(eintrag);
		this.getBenutzer(empf�nger).getPinnwand().getEintraege().add(eintrag);
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

		gruppenEinladung.setBearbeitet(true);
		gruppeService.getGruppe(gruppenEinladung.getAnhang()).setAnzahlMitglieder(gruppeService.getGruppe(gruppenEinladung.getAnhang()).getAnzahlMitglieder()+1);
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

		ArrayList<Badge> hilfsListe = new ArrayList<Badge>();
		badgeService.listAllBadge();

		for (Badge badge : badgeService.listAllBadge()) {
			hilfsListe.add(badge);
		}

		Badge temp;
		for (int i = 1; i < hilfsListe.size(); i++) {
			for (int j = 0; j < hilfsListe.size() - i; j++) {
				if (hilfsListe.get(j).getBen�tigtePunkte() > hilfsListe.get(
						j + 1).getBen�tigtePunkte()) {
					temp = hilfsListe.get(j);
					hilfsListe.set(i, hilfsListe.get(j + 1));
					hilfsListe.set(j + 1, temp);
				}

			}
		}
		int z�hler = 0;
		while ((hilfsListe.get(z�hler).getBen�tigtePunkte() < this.getBenutzer(
				benutzer).getPunktzahl())
				|| (hilfsListe.get(hilfsListe.size() - 1).getBen�tigtePunkte() < this
						.getBenutzer(benutzer).getPunktzahl())) {
			z�hler = z�hler + 1;
		}
		if ((!hilfsListe.get(z�hler).equals(
				this.getBenutzer(benutzer).getBadge()))
				&& (!hilfsListe.get(hilfsListe.size() - 1).equals(
						this.getBenutzer(benutzer).getBadge())))
			this.getBenutzer(benutzer).setBadge(hilfsListe.get(z�hler));
	}

	@Transactional
	public void registrieren(String benutzername,String vorname, String nachname,
			String studiengang, String tag, String monat, String jahr,
			String passwort, String geschlecht) {
		
		
		List<Studiengang>alleStudieng�nge=studiengangservice.listAllStudiengang();
		
		int studiengangid=0;
		for(Studiengang s: alleStudieng�nge){
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
