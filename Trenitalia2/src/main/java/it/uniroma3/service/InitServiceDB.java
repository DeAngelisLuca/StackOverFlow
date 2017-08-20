package it.uniroma3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import it.uniroma3.model.Ruolo;
import it.uniroma3.model.Utente;
import it.uniroma3.repository.AbilitazioneRepository;
import it.uniroma3.repository.DipendenteRepository;
import it.uniroma3.repository.RuoloRepository;
import it.uniroma3.repository.UtenteRepository;
import it.uniroma3.repository.VisitatoreRepository;

@Transactional
@Service
public class InitServiceDB {
	
	@Autowired
	private RuoloRepository ruoloRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Autowired
	private AbilitazioneRepository abilitazioneRepository;
	
	@Autowired
	private VisitatoreRepository visitatoreRepository;
	
	@PostConstruct
	public void init(){
		
		Ruolo roleUser = new Ruolo();
		roleUser.setNome("ROLE_USER");
		ruoloRepository.save(roleUser);
		
		Ruolo roleAdmin = new Ruolo();
		roleAdmin.setNome("ROLE_ADMIN");
		ruoloRepository.save(roleAdmin);
		
		Utente userAdmin = new Utente();
		userAdmin.setNome("admin");
		userAdmin.setEmail("admin@gmail.com");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setEnabled(true);
		List<Ruolo> ruoli = new ArrayList<Ruolo>();
		ruoli.add(roleAdmin);
		ruoli.add(roleUser);
		userAdmin.setRuoli(ruoli);
		utenteRepository.save(userAdmin);
		
	}

}
