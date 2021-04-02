package com.codingdojo.java.week1.javafun.javaoop.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.models.Ninja;
import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	public Ninja addNinja (Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	public Optional<Ninja> getNinja(Long id){
		return ninjaRepository.findById(id);
	}
}
