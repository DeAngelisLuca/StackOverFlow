package it.uniroma3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Visitatore;
import it.uniroma3.repository.VisitatoreRepository;

@Service
@Transactional
public class VisitatoreService {
	
	@Autowired
	private VisitatoreRepository visitatoreRepository;
	
	public List<Visitatore> findAll(){
		return visitatoreRepository.findAll();
	}
	
	public Visitatore findOne(Long id){
		return visitatoreRepository.findOne(id);
	}
	
	public void save(Visitatore visitatore){
		visitatoreRepository.save(visitatore);
	}
	
	public void delete(Long id){
		visitatoreRepository.delete(id);
	}
	
	
}
