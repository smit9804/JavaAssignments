package com.codingdojo.java.week1.javafun.javaoop.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.java.week1.javafun.javaoop.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long> {

		List<Lookify> findAll();
		
		List<Lookify> findByArtistContaining(String search);
		
		Optional<Lookify> findById(Long id);
		
		void deleteById(Long id);

		List<Lookify> findByArtist(String artist);
		
}
