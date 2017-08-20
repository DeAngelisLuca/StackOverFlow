package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.model.Visitatore;
import it.uniroma3.service.VisitatoreService;

@Controller
public class VisitatoreController {

	@Autowired
	private VisitatoreService visitatoreService;

	@ModelAttribute("visitatore")
	public Visitatore nuovoVisitatore(){
		return new Visitatore();
	}

	@RequestMapping("/registrazioneVisitatore")
	public String formDelNuovoVisitatore(){
		return "nuovoVisitatore";
	}

	@RequestMapping(value="/registrazioneVisitatore" , method = RequestMethod.POST)
	public String nuovoVisitatoreDaForm(@Valid @ModelAttribute("visitatore") Visitatore visitatore , BindingResult result){
		if(result.hasErrors())
			return "nuovoVisitatore";
		else{
			List<Visitatore> visitatoriReg = new ArrayList<Visitatore>();
			visitatoriReg = visitatoreService.findAll();
			for(Visitatore vis : visitatoriReg){
				if(vis.getEmail().equals(visitatore.getEmail()))
					return "redirect:/registrazioneVisitatore?success=false"; ///registrazioneVisitatore fa riferimento al request mapping che porta alla form jsp
			}
			
			visitatore.setNome(visitatore.getNome().toUpperCase());
			visitatore.setCognome(visitatore.getCognome().toUpperCase());
			visitatore.setEmail(visitatore.getEmail().toLowerCase());
			
			visitatoreService.save(visitatore);
			
			return "redirect:/registrazioneVisitatore?success=true";
			
			
		}
	}




}
