package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

import it.uniroma3.comparatori.ComparatoreDipendente;
import it.uniroma3.model.Abilitazione;
import it.uniroma3.model.Dipendente;
import it.uniroma3.model.Utente;
import it.uniroma3.service.DipendenteService;
//Collegato a dettagliDipendente.jsp e nuovoDipendente.jsp e modificaDipendente.jsp
@Controller
public class DipendenteController {
	
	@Autowired
	private DipendenteService dipendenteService;
	
	
	
	@ModelAttribute("dipendente")
	public Dipendente constructDipendente(){
		return new Dipendente();
	}
	
	
	
	@RequestMapping("/dipendente")
	public String showArtistForm(){
		return "nuovoDipendente";
	}
	
	@RequestMapping(value="/dipendente", method = RequestMethod.POST)
	public String newDipendente(@Valid @ModelAttribute("dipendente") Dipendente dipendente, BindingResult result){
		if(result.hasErrors())
			return "nuovoDipendente";
		else{
			List<Dipendente> dipendenteReg = new ArrayList<Dipendente>();
			dipendenteReg = dipendenteService.findAll();
			for(Dipendente dip : dipendenteReg){
				if(dip.getCid().intValue()==dipendente.getCid().intValue())
					return "redirect:/dipendente?success=false";
			}
			//Alla creazione del dipendente porto tutto in maiuscolo
			dipendente.setNome(dipendente.getNome().toUpperCase());
			dipendente.setCognome(dipendente.getCognome().toUpperCase());
			dipendente.setImpianto(dipendente.getImpianto().toUpperCase());
			
			dipendenteService.save(dipendente);
			return "redirect:/dipendente?success=true";
		}
	}
	
	
	
	@RequestMapping("/dipendenti")
	public String listArtist(Model model){
		List<Dipendente> dipendenti = new ArrayList<Dipendente>(dipendenteService.findAll());
		ComparatoreDipendente comp = new ComparatoreDipendente();
		Collections.sort(dipendenti,comp);
		
		model.addAttribute("dipendenti", dipendenti);
		model.addAttribute("dipendentiSize", dipendenti.size());
			
		return "dipendenti";
	}
	
	
	@RequestMapping("/dipendenti/{id}")
	public String getDipendente(@PathVariable Long id, Model model){
	
		
		// cerca il dipendente e gli setta le sue abilitazioni
		Dipendente dipendente = dipendenteService.findOneWithAbilitazione(id);
		model.addAttribute("dipendente", dipendente);
		model.addAttribute("dipendenteNumeroAbilitazioni",dipendente.getAbilitazioni().size());
	
		
		
		return "dettagliDipendente";
	}
	
	
	
	@RequestMapping("/dipendenti/remove/{id}")
	public String deleteDipendente(@PathVariable Long id){
		dipendenteService.delete(id);
		return "redirect:/dipendenti";
	}
	
	
	
	@RequestMapping("/modifica/{id}")
	public String editDipendente(@PathVariable Long id, Model model){
		Dipendente dipendente = dipendenteService.findOne(id);
		model.addAttribute("dipendenteDaModificare", dipendente);
		return "modificaDipendente";
	}
	
	@RequestMapping(value="/modifica/{id}", method = RequestMethod.POST)
	public ModelAndView editCrudDipendente(@PathVariable Long id,@Valid @ModelAttribute("dipendenteDaModificare") Dipendente dipendente, BindingResult result){
		if(result.hasErrors())
			return new ModelAndView("modificaDipendente","dipendente", dipendente);
		else{
			dipendente.setImpianto(dipendente.getImpianto().toUpperCase());
			dipendente.setNome(dipendente.getNome().toUpperCase());
			dipendente.setCognome(dipendente.getCognome().toUpperCase());
			dipendenteService.save(dipendente);
			return new ModelAndView("redirect:/modifica/{id}?success=true");
		}
	}
	

}
