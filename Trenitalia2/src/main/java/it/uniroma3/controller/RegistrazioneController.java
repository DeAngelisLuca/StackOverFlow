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

import it.uniroma3.model.Utente;
import it.uniroma3.service.UtenteService;

//<!-- Collegato all' index.jsp e all'user-register.jsp Ok! -->

@Controller
@RequestMapping("/register")
public class RegistrazioneController {
	
	@Autowired
	private UtenteService utenteService;
	
	@ModelAttribute("user")
	public Utente constructUser(){
		return new Utente();
	}
	
	@RequestMapping
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String newRegister(@Valid @ModelAttribute("user") Utente user, BindingResult result){
		if(result.hasErrors())
			return "user-register";
		else{
			List<Utente> utentiReg = new ArrayList<Utente>();
			utentiReg = utenteService.findAll();
			for(Utente u : utentiReg){
				if(u.getNome().equals(user.getNome()))
					return "redirect:/register?success=false";
			}
			//
			utenteService.save(user);
			return "redirect:/register?success=true";
		}
	}

}
