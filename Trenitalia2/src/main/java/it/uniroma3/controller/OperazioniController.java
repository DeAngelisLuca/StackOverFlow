package it.uniroma3.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.model.Utente;
import it.uniroma3.service.UtenteService;

//<!-- Collegato all' operazioni.jsp -->
@Controller
public class OperazioniController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String nameUser = principal.getName(); // Principal si basa sull'utente autenticato
		Utente utente = utenteService.findOneWithName(nameUser);
		model.addAttribute("user", utente);
		return "operazioni";
	}

}
