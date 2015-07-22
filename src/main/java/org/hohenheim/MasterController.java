package org.hohenheim;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.plp.benutzer.Benutzer;
import org.plp.benutzer.Eintrag;
import org.plp.benutzer.Geburtsdatum;
import org.plp.benutzer.StringHilfsklasse;
import org.plp.benutzer.Studiengang;
import org.plp.dao.BenutzerService;
import org.plp.dao.EintragService;
import org.plp.dao.PinnwandService;
import org.plp.dao.StudiengangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;





@Controller
public class MasterController {
	
	Benutzer aktiverBenutzer;
	
	Benutzer profilBenutzer;
	
	int aktiverBenutzerid;
	int profilBenutzerid;
	
	@Autowired
	FileValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {

		binder.setValidator(validator);

	}
	
	@Autowired
	BenutzerService benutzerservice;
	
	@Autowired
	StudiengangService studiengangservice;
	
	@Autowired
	EintragService eintragservice;
	
	@Autowired
	PinnwandService pinnwandservice;
	
	
	
	
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
		model.addAttribute("studiengänge", studiengaenge);
		
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
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model){
		
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		model.addAttribute("eintragsText", new StringHilfsklasse());
		ArrayList<Eintrag> sortierteEinträge = pinnwandservice.einträgeSortieren(benutzerservice.getBenutzer(aktiverBenutzerid).getPinnwand().getPinnwand_id());
		model.addAttribute("sortierteEintraege", sortierteEinträge);
		model.addAttribute("profilBenutzer", benutzerservice.getBenutzer(profilBenutzerid));
		
		
		return "home";
		
		
		
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
				aktiverBenutzerid=benutzerid;
				
				model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(benutzerid));
				model.addAttribute("eintragsText", new StringHilfsklasse());
				ArrayList<Eintrag> sortierteEinträge = pinnwandservice.einträgeSortieren(benutzerservice.getBenutzer(aktiverBenutzerid).getPinnwand().getPinnwand_id());
				model.addAttribute("sortierteEintraege", sortierteEinträge);
				return "home";
				
			}else{
				model.addAttribute("message", "Falsches Passwort");
				model.addAttribute("geburtsdatum", new Geburtsdatum());
				return "LogIn";
			}
			
		}else{
			model.addAttribute("message", "Falscher Benutzername");
			model.addAttribute("geburtsdatum", new Geburtsdatum());
			return "LogIn";
		}
		
		
	}
	
	@RequestMapping(value="/eintragSchreiben", method=RequestMethod.POST)
	public String eintragSchreiben(@ModelAttribute String eintragsText, @ModelAttribute Benutzer aktiverBenutzer, Model model){
		System.out.println(eintragsText);
		System.out.println(aktiverBenutzer.getBenutzer_id());
		benutzerservice.eintragErstellen(eintragsText, aktiverBenutzerid, profilBenutzerid, aktiverBenutzer.getBenutzer_id());
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		model.addAttribute("eintragsText", new StringHilfsklasse());
		ArrayList<Eintrag> sortierteEintraege = pinnwandservice.einträgeSortieren(benutzerservice.getBenutzer(profilBenutzerid).getPinnwand().getPinnwand_id());
		model.addAttribute("sortierteEintraege", sortierteEintraege);
		model.addAttribute("profilBenutzer", benutzerservice.getBenutzer(profilBenutzerid));
		return "Profil";
		
	}
		
		@RequestMapping(value="/eintragSchreibenEigenesProfil", method=RequestMethod.POST)
		public String eintragSchreibenEigenesProfil(@ModelAttribute String eintragsText, @ModelAttribute Benutzer aktiverBenutzer, Model model){
			System.out.println(eintragsText);
			System.out.println(aktiverBenutzer.getBenutzer_id());
			benutzerservice.eintragErstellen(eintragsText, aktiverBenutzerid, aktiverBenutzerid, aktiverBenutzer.getBenutzer_id());
			model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
			model.addAttribute("eintragsText", new StringHilfsklasse());
			ArrayList<Eintrag> sortierteEinträge = pinnwandservice.einträgeSortieren(benutzerservice.getBenutzer(aktiverBenutzerid).getPinnwand().getPinnwand_id());
			model.addAttribute("sortierteEintraege", sortierteEinträge);
			model.addAttribute("profilBenutzer", benutzerservice.getBenutzer(profilBenutzerid));
			return "home";
		
		
		
	}
	
	@RequestMapping(value="/profil/{benutzerName}", method=RequestMethod.GET)
	public String profilAnzeigen(@ModelAttribute Benutzer aktiverBenutzer, @PathVariable String benutzerName, Model model){
		
		
		
		List<Benutzer>alleBenutzer=benutzerservice.listAllBenutzer();
		
		int benutzerid=0;
		for(Benutzer b: alleBenutzer){
			
			if(b.getBenutzerName().equals(benutzerName)){
				
				benutzerid=b.getBenutzer_id();
				profilBenutzerid=benutzerid;
				
			}
			
		}
		
		
		profilBenutzer=benutzerservice.getBenutzer(benutzerid);
		
		model.addAttribute("profilBenutzer", benutzerservice.getBenutzer(profilBenutzerid));
		model.addAttribute("eintragsText", new StringHilfsklasse());
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		model.addAttribute("eintragsText", new StringHilfsklasse());
		ArrayList<Eintrag> sortierteEinträge = pinnwandservice.einträgeSortieren(benutzerservice.getBenutzer(profilBenutzerid).getPinnwand().getPinnwand_id());
		model.addAttribute("sortierteEintraege", sortierteEinträge);
	
		
		return "Profil";
		
		
	}
	
	
	@RequestMapping(value="/freunde", method=RequestMethod.GET)
	public String freundesliste(@ModelAttribute Benutzer aktiverBenutzer, Model model){
		
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		
		return "Freundesliste";
		
		
	}
	
	
	@RequestMapping(value="/gruppen", method=RequestMethod.GET)
	public String gruppenliste(@ModelAttribute Benutzer aktiverBenutzer, Model model){
		
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		
		return "Gruppenliste";
		
		
	}
	
	@RequestMapping(value="/benutzer", method=RequestMethod.GET)
	public String benutzerliste(@ModelAttribute Benutzer aktiverBenutzer, Model model){
		
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		List<Benutzer>alleBenutzer= new ArrayList<Benutzer>();
		for (Benutzer b: benutzerservice.listAllBenutzer()){
			alleBenutzer.add(b);
			
		}
		
		model.addAttribute("alleBenutzer", alleBenutzer);
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		model.addAttribute("eintragsText", new StringHilfsklasse());
		ArrayList<Eintrag> sortierteEinträge = pinnwandservice.einträgeSortieren(benutzerservice.getBenutzer(aktiverBenutzerid).getPinnwand().getPinnwand_id());
		model.addAttribute("sortierteEintraege", sortierteEinträge);
		model.addAttribute("profilBenutzer", benutzerservice.getBenutzer(profilBenutzerid));
		
		return "Benutzerliste";
		
		
	}
	
	@RequestMapping(value="/einstellungen", method=RequestMethod.GET)
	public String einstellen(@ModelAttribute Benutzer aktiverBenutzer, Model model){
		
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		
		return "Profileinstellungen";
		
		
	}
	
	@RequestMapping(value="/gruppeErstellen", method=RequestMethod.GET)
	public String gruppeErstellen(@ModelAttribute Benutzer aktiverBenutzer, Model model){
		
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		
		return "GruppeErstellen";
		
		
	}
	
	@RequestMapping(value="/quest", method=RequestMethod.GET)
	public String questStarten(@ModelAttribute Benutzer aktiverBenutzer, Model model){
		
		model.addAttribute("aktiverBenutzer", benutzerservice.getBenutzer(aktiverBenutzerid));
		
		return "Aufgabe";
		
		
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public String getForm(Model model) {
		FileTest fileModel = new FileTest();
		model.addAttribute("file", fileModel);
		model.addAttribute("dateiname", new StringHilfsklasse());
		return "file";

	}

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public String fileUploaded(Model model, @Validated FileTest file,
			BindingResult result, HttpServletRequest request) {

		String returnVal = "succesFile";
		if (result.hasErrors()) {
			returnVal = "file";
		} else {
			MultipartFile multipartFile = file.getFile();

			ServletContext context = request.getServletContext();
	        String projektPfad = context.getRealPath("");
	        String [] pfad = projektPfad.split("workspace");
			String orgName = multipartFile.getOriginalFilename();
			String speicherort = pfad[0] + "/workspace/SoftwarePraktikum/uploads/" + orgName;
			File desk = new File(speicherort);

			try {
				multipartFile.transferTo(desk);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return returnVal;
	}

	@RequestMapping(value = "/filedownload", method = RequestMethod.POST)
	public @ResponseBody void downloadFiles(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute StringHilfsklasse dateiname) {

		ServletContext context = request.getServletContext();

		String fileName=dateiname.getString();
		
		File downloadFile = new File(
				"C:/Users/Patrick/workspace/SoftwarePraktikum/uploads/"+fileName);
		FileInputStream inputStream = null;
		OutputStream outStream = null;

		try {
			inputStream = new FileInputStream(downloadFile);

			response.setContentLength((int) downloadFile.length());
			response.setContentType(context
					.getMimeType("C:/JavaHonk/CustomJar.jar"));

			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",
					downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			// Write response
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != inputStream)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	
	

}
