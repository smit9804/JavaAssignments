package com.codingdojo.java.week1.javafun.javaoop.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.java.week1.javafun.javaoop.lookify.models.Lookify;
import com.codingdojo.java.week1.javafun.javaoop.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	public List<Lookify> allLookify(){
		return lookifyRepository.findAll();
	}
	public Lookify createLookify(Lookify a) {
		return lookifyRepository.save(a);
	}
	public Lookify findLookify(Long id) {
		Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
		if(optionalLookify.isPresent()) {
			return optionalLookify.get();
		}
		else {
			return null;
		}
	}
	public Lookify updateLookify(Lookify a) {
		return lookifyRepository.save(a);
	}
	public Lookify updateLookify(Long id, String name, Integer rating, String artist) {
		Optional <Lookify> lookify = lookifyRepository.findById(id);
		if (lookify != null) {
			lookify.get().setName(name);
			lookify.get().setRating(rating);
			lookify.get().setArtist(artist);
			
			return lookify.get();
		}
		return null;
	}
	public void deleteLookify(Long id) {
		lookifyRepository.deleteById(id);
	}
	public List<Lookify> getSearchSongs(String artist) {
			return lookifyRepository.findByArtist(artist);
	}
}
