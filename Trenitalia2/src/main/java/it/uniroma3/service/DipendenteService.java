package it.uniroma3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Abilitazione;
import it.uniroma3.model.Dipendente;
import it.uniroma3.repository.AbilitazioneRepository;
import it.uniroma3.repository.DipendenteRepository;

@Service
@Transactional
public class DipendenteService {
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	@Autowired
	private AbilitazioneRepository abilitazioneRepository;
	
	public List<Dipendente> findAll(){
		return dipendenteRepository.findAll();
	}
	
	public Dipendente findOne(Long id){
		return dipendenteRepository.findOne(id);
	}
	
	public Dipendente findOneWithNome(String nome){
		Dipendente dip = dipendenteRepository.findByNome(nome);
		return findOne(dip.getId());
	}
	
	public void save(Dipendente dip){
		dipendenteRepository.save(dip);
	}
	
	public void delete(Long id){
		dipendenteRepository.delete(id);
	}

	public Dipendente findOneWithAbilitazione(Long id) {
		Dipendente dip = findOne(id);
		List<Abilitazione> abilitazioni = abilitazioneRepository.findByDipendente(dip);
		dip.setAbilitazioni(abilitazioni);
		return dip;
	}

}
