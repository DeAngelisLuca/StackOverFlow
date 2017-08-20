package it.uniroma3.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.comparatori.ComparatoreUtente;
import it.uniroma3.model.Utente;
import it.uniroma3.service.UtenteService;
//<!-- Collegato all' users.jsp -->
@Controller
public class AmministratoreController {

	@Autowired
	private UtenteService utenteService;
	
	
	// riporta lista utenti ordinati con nome e mail
	@RequestMapping("/users") 
	public String users(Model model){
		ComparatoreUtente comp = new ComparatoreUtente();
		List<Utente> utenti = utenteService.findAll();
		Collections.sort(utenti, comp);
		
		
		model.addAttribute("users", utenti);
		return "users";
	} 
	
	// cancella utente dalla lista utenti
	@RequestMapping("users/remove/{id}")
	public String removeUser(@PathVariable Long id){
		utenteService.delete(id);
		return "redirect:/users";
	}
}
