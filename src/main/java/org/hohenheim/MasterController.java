package org.hohenheim;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Benutzer;
import org.plp.benutzer.Eintrag;
import org.plp.benutzer.Geburtsdatum;
import org.plp.benutzer.StringHilfsklasse;
import org.plp.benutzer.Studiengang;
import org.plp.dao.BenutzerService;
import org.plp.dao.EintragService;
import org.plp.dao.StudiengangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class MasterController {
	
	Benutzer aktiverBenutzer;
	
	@Autowired
	BenutzerService benutzerservice;
	
	@Autowired
	StudiengangService studiengangservice;
	
	@Autowired
	EintragService eintragservice;
	
	
	
	
	@Transactional
	@RequestMapping(value="/")
	public String begin (Model model){

//		Benutzer b= new Benutzer();
//		b.setBenutzerName("Sükrü");
//		
//		Benutzer a= new Benutzer();
//		a.setBenutzerName("Benni");
//		
//		benutzerservice.addNewBenutzer(b);
//		benutzerservice.addNewBenutzer(a);
		
//		Studiengang s= new Studiengang();
//		s.setName("Wirtschaftsinformatik");
//		studiengangservice.addNewStudiengang(s);
//		
//		Studiengang s1= new Studiengang();
//		s1.setName("Informatik");
//		studiengangservice.addNewStudiengang(s1);
		
//		Eintrag e1 = new Eintrag();
//		e1.setEintragstext("Dies ist ein Test");
//		e1.setAutor(benutzerservice.getBenutzer(27));
//		benutzerservice.getBenutzer(27).getEinträge().add(e1);
//		eintragservice.addNewEintrag(e1);
//		e1.setPinnwand(benutzerservice.getBenutzer(28).getPinnwand());
//		benutzerservice.getBenutzer(28).getPinnwand().getEintraege().add(e1);
//		
//		Eintrag e2 = new Eintrag();
//		e2.setEintragstext("Dies ist ein Test");
//		e2.setAutor(benutzerservice.getBenutzer(22));
//		benutzerservice.getBenutzer(22).getEinträge().add(e1);
//		eintragservice.addNewEintrag(e2);
//		e2.setPinnwand(benutzerservice.getBenutzer(28).getPinnwand());
//		benutzerservice.getBenutzer(28).getPinnwand().getEintraege().add(e2);
		
		
		
		List<String> geschlechter = new ArrayList<String>();
		geschlechter.add("männlich");
		geschlechter.add("weiblich");
		
		model.addAttribute("benutzer", new Benutzer());
		model.addAttribute("message", "");
		model.addAttribute("geburtsdatum", new Geburtsdatum());
		model.addAttribute("geschlechter", geschlechter);
		
		
		
		List<Studiengang> studiengaenge=studiengangservice.listAllStudiengang();
		model.addAttribute("studiengaenge", studiengaenge);
		
		return "LogIn";
		
		
		
		
		
	}
	
	@RequestMapping(value="/registrieren", method=RequestMethod.POST)
	public String registrieren(@ModelAttribute Benutzer benutzer, @ModelAttribute Geburtsdatum geburtsdatum,   Model model){
		
		
		List<Benutzer>alleBenutzer=benutzerservice.listAllBenutzer();
		
		for(Benutzer b:alleBenutzer){
			System.out.println(benutzer.getBenutzerName()); 
			System.out.println(b.getBenutzerName());
			if (b.getBenutzerName().equals(benutzer.getBenutzerName())){
				model.addAttribute("message1", "Benutzername bereits vergeben");
				return "LogIn";
			}
		}
		
		benutzerservice.registrieren(benutzer.getBenutzerName(),benutzer.getVorname(), benutzer.getNachname(), "Informatik", geburtsdatum.getTag(), geburtsdatum.getMonat(), geburtsdatum.getJahr(), benutzer.getPasswort(), benutzer.getGeschlecht());
		
		model.addAttribute("message1", "Sie wurden erfolgreich registriert, bitte melden Sie sich an");
		return "LogIn";
		
	}
	
	
	
	@RequestMapping(value="/anmelden", method=RequestMethod.POST)
	public String anmelden(@ModelAttribute Benutzer benutzer, Model model){
		
		List<Benutzer>alleBenutzer=benutzerservice.listAllBenutzer();
		
		int benutzerid=0;
		boolean benutzerVorhanden=false;
		
		for (Benutzer b: alleBenutzer){
			
			if (b.getBenutzerName().equals(benutzer.getBenutzerName())){
				
				benutzerid=b.getBenutzer_id();
				benutzerVorhanden=true;
				
			}
			
		}
		
		if(benutzerVorhanden){
			
			if(benutzer.getPasswort().equals(benutzerservice.getBenutzer(benutzerid).getPasswort())){
				
				aktiverBenutzer=benutzerservice.getBenutzer(benutzerid);
				model.addAttribute("aktiverBenutzer", aktiverBenutzer);
				model.addAttribute("eintragsText", new StringHilfsklasse());
				return "home";
				
			}else{
				model.addAttribute("message", "Falsches Passwort");
				return "LogIn";
			}
			
		}else{
			model.addAttribute("message", "Falscher Benutzername");
			return "LogIn";
		}
		
		
	}
	
	@RequestMapping(value="/eintragSchreiben", method=RequestMethod.POST)
	public String eintragSchreiben(@ModelAttribute String eintragsText, @ModelAttribute Benutzer aktiverBenutzer, Model model){
		System.out.println(eintragsText);
		benutzerservice.eintragErstellen(eintragsText, aktiverBenutzer.getBenutzer_id(), aktiverBenutzer.getBenutzer_id(), aktiverBenutzer.getBenutzer_id());
		return "home";
	}
	
	

}
