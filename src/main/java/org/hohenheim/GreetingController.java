package org.hohenheim;

import javax.transaction.Transactional;

import org.plp.benutzer.Badge;
import org.plp.benutzer.Benutzer;
import org.plp.benutzer.Mediathek;
import org.plp.benutzer.Pinnwand;
import org.plp.benutzer.User;
import org.plp.dao.AufgabeService;
import org.plp.dao.BadgeService;
import org.plp.dao.BenutzerService;
import org.plp.dao.FachrichtungService;
import org.plp.dao.GruppeService;
import org.plp.dao.MediathekService;
import org.plp.dao.NachrichtService;
import org.plp.dao.PinnwandService;
import org.plp.grundfunktionen.Nachrichtengenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Autowired
	private BenutzerService benutzerservice;

	@Autowired
	private GruppeService gruppenservice;

	@Autowired
	private NachrichtService nachrichtservice;

	@Autowired
	private PinnwandService pinnwandservice;
	
	@Autowired
	private BadgeService badgeservice;
	
	@Autowired
	Nachrichtengenerator nachrichtengenerator;
	
	@Autowired
	MediathekService mediathekservice;
	
	@Autowired
	AufgabeService aufgabeService;
	
	@Autowired
	FachrichtungService fachrichtungService;
	

	public GreetingController() {

	}

	@Transactional
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String greeting(Model model) {

		//Mediathek m = new Mediathek();
		//mediathekservice.addNewMediathek(m);
		//System.out.println(m.getMediathek_id());
		
		
//		benutzerservice.freunschaftsAnfrageVersenden(1, 3, 1);
//		benutzerservice.frendschaftsAnfrageAnnehmen(nachrichtservice.getNachricht(19));
		
		
//		benutzerservice.addNewBenutzer("Paddy123", "Patrick", "Schmelzle");
//		badgeservice.addNewBadge();
//		badgeservice.addNewBadge();
		
		//Benutzer paddy = benutzerservice.getBenutzer(3);
		//Badge supergemacht = badgeservice.getBadge(1);
		
//		badgeservice.getBadge(2).getBesitzer().add(benutzerservice.getBenutzer(3));
//		benutzerservice.getBenutzer(3).getBadges().add(badgeservice.getBadge(2));
//		for (Badge b : benutzerservice.getBenutzer(3).getBadges()){
//			System.out.println(b.getName());
//		}
//		
//		benutzerservice.getBenutzer(3).getBadges().add(badgeservice.getBadge(2));
//		for (Benutzer b : badgeservice.getBadge(2).getBesitzer()){
//			System.out.println(b.getBenutzerName());
//		}
//		badgeservice.getBadge(1).getBesitzer().add(benutzerservice.getBenutzer(3));
		
//		benutzerservice.update(paddy);
		//badgeservice.update(supergemacht);
		
		//pinnwandservice.addNewPinnwand();
		//pinnwandservice.addNewPinnwand();
		
//		Benutzer sükrü = benutzerservice.getBenutzer(1);
//		Benutzer benno = benutzerservice.getBenutzer(2);
//		
//		sükrü.setPinnwand(pinnwandservice.getPinnwand(1));
//		benutzerservice.update(sükrü);
//		System.out.println(sükrü.getPinnwand().getPinnwand_id());
//		benno.setPinnwand(pinnwandservice.getPinnwand(2));
//		benutzerservice.update(benno);
		
		//benutzerservice.getBenutzer(1).setPinnwand(pinnwandservice.getPinnwand(1));
		//benutzerservice.update(sükrü);
//		benutzerservice.getBenutzer(2).setPinnwand(pinnwandservice.getPinnwand(2));
//		System.out.println(pinnwandservice.getPinnwand(2).getPinnwand_id());
		//benutzerservice.update(benno);

		//benutzerservice.eintragErstellen("Hey Benni, darf ich nochmal lutschen, bitte?", 1, 2, 1);
		
		
		// benutzerservice.addNewBenutzer("sürkrü123", "Sükrü", "Sever");
		// benutzerservice.addNewBenutzer("Beno123", "Benjo", "Mahenjo");

		// nachrichtengenerator.freundschaftsanfrageErstellen(1, 2, 1, false,
		// false);
		// nachrichtengenerator.freundschaftsanfrageAngenommenErstllen(2, 1, 2,
		// false, true);

		//benutzerservice.freunschaftsAnfrageVersenden(1, 2, 1);
		//System.out.println(nachrichtservice.getNachricht(10).getInhalt());
		//benutzerservice.frendschaftsAnfrageAnnehmen(nachrichtservice.getNachricht(10));
		
		//benutzerservice.freunschaftsAnfrageVersenden(2, 1, 2);
		// Benutzer sükrü = benutzerservice.getBenutzer(2);
		// sükrü.frendschaftsAnfrageAnnehmen(freundschaftsanfrage);
		//
		Message message = new Message();
		message.setInhat("Willkommen bei PLP, deiner SocialLearningPlattform");

		model.addAttribute("benutzer", new Benutzer());
		model.addAttribute("message", message);

		return "LogIn";
	}

}
