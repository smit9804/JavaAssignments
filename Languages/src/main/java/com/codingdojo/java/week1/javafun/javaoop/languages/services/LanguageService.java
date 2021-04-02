package com.codingdojo.java.week1.javafun.javaoop.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.java.week1.javafun.javaoop.languages.models.LanguageModels;
import com.codingdojo.java.week1.javafun.javaoop.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	public List<LanguageModels> allLanguages(){
		return languageRepository.findAll();
	}
	public LanguageModels createLanguage(LanguageModels a) {
		return languageRepository.save(a);
	}
	public LanguageModels findLanguage(Long id) {
		Optional<LanguageModels> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	public LanguageModels updateLanguage(LanguageModels a) {
		return languageRepository.save(a);
	}
	public LanguageModels updateLanguage(Long id, String name, String creator, String version) {
		Optional <LanguageModels> language = languageRepository.findById(id);
		if (language != null) {
			language.get().setName(name);
			language.get().setCreator(creator);
			language.get().setVersion(version);
			
			return language.get();
		}
		return null;
	}
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}
