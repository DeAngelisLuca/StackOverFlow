package it.uniroma3.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Ruolo;
import it.uniroma3.model.Utente;
import it.uniroma3.repository.RuoloRepository;
import it.uniroma3.repository.UtenteRepository;

@Service
@Transactional
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	@Autowired
	private RuoloRepository ruoloRepository;
	
	public List<Utente> findAll(){
		return utenteRepository.findAll();
	}
	
	public Utente findOne(Long id){
		return utenteRepository.findOne(id);
	}
	
	public void save(Utente user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Ruolo> roles = new ArrayList<Ruolo>();
		roles.add(ruoloRepository.findByNome("ROLE_USER"));
		user.setRuoli(roles);
		
		utenteRepository.save(user);
	}
	
	public Utente findOneWithName(String nameUser) {
		Utente user = utenteRepository.findByNome(nameUser);
		return findOne(user.getId());
	}
	
	public void delete(Long id) {
		utenteRepository.delete(id);		
	}

}
