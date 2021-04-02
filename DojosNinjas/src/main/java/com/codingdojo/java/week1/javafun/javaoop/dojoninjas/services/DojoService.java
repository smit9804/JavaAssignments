package com.codingdojo.java.week1.javafun.javaoop.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.models.Dojo;
import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	public Dojo addDojo (Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	public Dojo getDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} 
		else {
			return null;
		}

	}
}
