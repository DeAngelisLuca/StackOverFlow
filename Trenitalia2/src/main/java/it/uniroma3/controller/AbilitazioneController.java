package it.uniroma3.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import it.uniroma3.model.Abilitazione;
import it.uniroma3.model.Dipendente;
import it.uniroma3.service.AbilitazioneService;

import it.uniroma3.service.DipendenteService;

//Collegato a dettagliDipendente.jsp
@Controller
public class AbilitazioneController {

	@Autowired
	private AbilitazioneService abilitazioneService;
	@Autowired
	private DipendenteService dipendenteService;

	@ModelAttribute("abilitazione")
	public Abilitazione constructAbilitazione(){
		return new Abilitazione();
	}

	@RequestMapping("/abilitazione")
	public String newAbilitazione(){
		return "nuovaAbilitazione";
	}

	@RequestMapping("/abilitazione/{id}")
	public ModelAndView newAbilitazioneWithId(@PathVariable Long id){
		Dipendente dipendente = dipendenteService.findOne(id);
		ModelAndView model = new ModelAndView("nuovaAbilitazione");
		model.addObject("dipendenteID", dipendente.getId());
		return model;
	}

	@RequestMapping(value="/abilitazione/{id}", method = RequestMethod.POST)
	public ModelAndView newAbilitazione(
			HttpSession session,
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("abilitazione") Abilitazione abilitazione, 
			BindingResult result){


		if(result.hasErrors()){
			return new ModelAndView("nuovaAbilitazione", "dipendenteID", id);
		}
		else{
				Dipendente dipendente = dipendenteService.findOne(id);
					ServletContext context = session.getServletContext();
					//CONTROLLO INSERIMENTO STESSA ABILITAZIONE PER LO STESSO DIPENDENTE
					
					List<Abilitazione> abilitazioniDelDipendente = new ArrayList<Abilitazione>();
					abilitazioniDelDipendente = abilitazioneService.findAllAbilitazioniDi(dipendente);
					
					
					
					//porto il nome DELLE ABILITAZIONI in maiuscolo
					abilitazione.setNomeAbilitazione(abilitazione.getNomeAbilitazione().toUpperCase());
					abilitazione.setInfo(abilitazione.getInfo().toUpperCase());
					//creo le date scadenzaTot e conseguimentoTot
					LocalDate dataScadenzaTot = LocalDate.of(abilitazione.getAnnoScadenza(), abilitazione.getMeseScadenza(), abilitazione.getGiornoScadenza());
					abilitazione.setDataScadenzaAbilitazioneTot(dataScadenzaTot);
					LocalDate dataConseguimentoTot = LocalDate.of(abilitazione.getAnnoConseguimento(), abilitazione.getMeseConseguimento(), abilitazione.getGiornoConseguimento());
					abilitazione.setDataConseguimentoAbilitazioneTot(dataConseguimentoTot);
					
					
					
					
					for(Abilitazione abi : abilitazioniDelDipendente){
						
						//porto il nome DELLE ABILITAZIONI in maiuscolo
						abi.setNomeAbilitazione(abi.getNomeAbilitazione().toUpperCase());

						if(abi.getNomeAbilitazione().equals(abilitazione.getNomeAbilitazione()))
							return new ModelAndView("redirect:/abilitazione/"+id+"?success=false");
				}
		
			
					//FINE CONTROLLO
					
					
						abilitazione.setDipendente(dipendente);
						abilitazioneService.save(abilitazione);
						
			
						
						return new ModelAndView("redirect:/abilitazione/"+id+"?success=true");
				}
		}
		//DA CORREGGERE
		//PER LA MODIFICA DI UNA ABILITAZIONE DI UN DIP value="/modificaAbilitazione/${abilitazione.id}"
	@RequestMapping("/modificaAbilitazione/{id}")
	public String editAbilitazione(@PathVariable Long id, Model model){
	//	Abilitazione abilitazione = abilitazioneService.findAbilitazioneConId(id);
	//	model.addAttribute("abilitazioneDaModificare", abilitazione);
		return "modificaAbilitazione";
	}
	
	@RequestMapping(value="/modificaAbilitazione/{id}", method = RequestMethod.POST)
	public String editCrudAbilitazione(@PathVariable Long id,@Valid @ModelAttribute("abilitazioneDaModificare") Abilitazione abilitazione, BindingResult result){
		if(result.hasErrors())
			return "modificaAbilitazione";
		else{
			
			Abilitazione abilitazione1 = abilitazioneService.findAbilitazioneConId(id);
			abilitazione1.setNomeAbilitazione(abilitazione.getNomeAbilitazione());
			
			
			
			
			
			return "redirect:/modificaAbilitazione/{id}?success=true";
		}
	}
	//DA CORREGGERE FINO A QUA
	
	//PER LA CANCELLAZIONE DI UNA ABILITAZIONE DI UN DIPENDENTE
	
	@RequestMapping("/eliminaAbilitazione/{id}")
	public String deleteSingolaAbilitazioneDelDipendente(@PathVariable Long id){
		
		Abilitazione abi = abilitazioneService.findAbilitazioneConId(id);
		Long idDip = abi.getDipendente().getId();
		abilitazioneService.delete(id);
		return "redirect:/dipendenti/"+idDip;
	}
		
	
	
	
	
	}
					

		

	


