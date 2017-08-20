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
//<!-- Collegato all' index.jsp -->
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}

}


