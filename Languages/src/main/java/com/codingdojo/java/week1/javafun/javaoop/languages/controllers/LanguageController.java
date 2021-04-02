package com.codingdojo.java.week1.javafun.javaoop.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.java.week1.javafun.javaoop.languages.models.LanguageModels;
import com.codingdojo.java.week1.javafun.javaoop.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<LanguageModels> language = languageService.allLanguages();
		model.addAttribute("language", language);
		return "/language/index.jsp";
	}
	@RequestMapping("/languages/new")
	public String newLanguage(@ModelAttribute("language")LanguageModels language) {
		return "/language/new.jsp";
	}
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language")LanguageModels language, BindingResult result) {
		if(result.hasErrors()) {
			return "/language/new.jsp";
		}
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		LanguageModels language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "language/show.jsp";
	}
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		LanguageModels language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/language/edit.jsp";
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") LanguageModels language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
