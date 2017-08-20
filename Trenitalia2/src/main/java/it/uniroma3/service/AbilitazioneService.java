package it.uniroma3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Abilitazione;
import it.uniroma3.model.Dipendente;
import it.uniroma3.repository.AbilitazioneRepository;


@Service
@Transactional
public class AbilitazioneService {
	
	@Autowired
	private AbilitazioneRepository abilitazioneRepository;
	
	public List<Abilitazione> findAll(){
		return abilitazioneRepository.findAll();
	}
	
	public void save(Abilitazione abilitazione){
		abilitazioneRepository.save(abilitazione);
	}
	
	public List<Abilitazione> findAllAbilitazioniDi(Dipendente dipendente){
		return abilitazioneRepository.findByDipendente(dipendente);
	}
	//aggiunta ora
	public Abilitazione findAbilitazioneConId(Long id){
		return abilitazioneRepository.findOne(id);
	}
	//aggiunta ora per la cancellazione
	public void delete(Long id){
		abilitazioneRepository.delete(id);
	}

}
