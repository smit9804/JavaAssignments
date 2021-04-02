package com.codingdojo.java.week1.javafun.javaoop.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.models.Ninja;
import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.services.DojoService;
import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public NinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjaObject") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newninja.jsp";
	}
	@PostMapping("/addNinja")
	public String addNinja(@Valid @ModelAttribute("ninjaObject") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "newninja.jsp";
		}
		else {
			ninjaService.addNinja(ninja);
			return "redirect:/dojos";
		}
	}
}
