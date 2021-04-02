package com.codingdojo.java.week1.javafun.javaoop.dojoninjas.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.models.Dojo;
import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.services.DojoService;
import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.services.NinjaService;


@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@GetMapping("/")
	public String index(@ModelAttribute("dojoObject") Dojo dojo, Model model) {
		return "redirect:/dojos";
	}
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojoObject")Dojo dojo) {
		return "newdojo.jsp";
	}
	@PostMapping(value="/addDojo")
	public String addDojo(@Valid @ModelAttribute("dojoObject") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newdojo.jsp";
		}
		else { 
			dojoService.addDojo(dojo);
			return "redirect:/dojos";
		}
	}
	@RequestMapping("/dojos")
	public String index(Model model) {
		List<Dojo> dojo = dojoService.allDojos();
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.getDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
}
