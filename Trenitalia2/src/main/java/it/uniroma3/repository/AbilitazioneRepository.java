package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.model.Dipendente;
import it.uniroma3.model.Abilitazione;

public interface AbilitazioneRepository extends JpaRepository<Abilitazione, Long>{

	List<Abilitazione> findByDipendente(Dipendente dipendente);
	

}
