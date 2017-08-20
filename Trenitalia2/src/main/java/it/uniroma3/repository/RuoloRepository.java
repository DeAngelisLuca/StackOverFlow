package it.uniroma3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.model.Ruolo;

public interface RuoloRepository extends JpaRepository<Ruolo, Long>{

	Ruolo findByNome(String name);

}
