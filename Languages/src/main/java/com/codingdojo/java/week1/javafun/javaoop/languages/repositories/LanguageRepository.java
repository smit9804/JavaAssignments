package com.codingdojo.java.week1.javafun.javaoop.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.week1.javafun.javaoop.languages.models.LanguageModels;
@Repository
public interface LanguageRepository extends CrudRepository<LanguageModels, Long> {

		List<LanguageModels> findAll();
		

		Optional<LanguageModels> findById(Long id);
		
		void deleteById(Long id);
}
