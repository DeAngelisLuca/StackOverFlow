package it.uniroma3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.model.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long>{

	Dipendente findByNome(String nome);

}
