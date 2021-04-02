package com.codingdojo.java.week1.javafun.javaoop.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.java.week1.javafun.javaoop.lookify.models.Lookify;
import com.codingdojo.java.week1.javafun.javaoop.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping
	public String index() {
		return "/lookify/index.jsp";
	}
	@RequestMapping("/lookify")
	public String dashboard(Model model) {
		List<Lookify> lookify = lookifyService.allLookify();
		model.addAttribute("lookify", lookify);
		return "/lookify/dashboard.jsp";
	}
	@RequestMapping("/lookify/new")
	public String newSong(@ModelAttribute("lookify")Lookify lookify) {
		return "/lookify/newsong.jsp";
	}
	@RequestMapping(value="/lookify", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("lookify")Lookify lookify, BindingResult result) {
		if(result.hasErrors()) {
			return "/lookify/newsong.jsp";
		}
		else {
			lookifyService.createLookify(lookify);
			return "redirect:/lookify";
		}
	}
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lookify lookify = lookifyService.findLookify(id);
		model.addAttribute("lookify", lookify);
		return "lookify/show.jsp";
	}
	@RequestMapping("/lookify/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Lookify lookify = lookifyService.findLookify(id);
		model.addAttribute("lookify", lookify);
		return "/lookify/edit.jsp";
	}
	@RequestMapping(value="/lookify/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
        if (result.hasErrors()) {
            return "/lookify/edit.jsp";
        } else {
            lookifyService.updateLookify(lookify);
            return "redirect:/lookify";
        }
    }
	@RequestMapping(value="/lookify/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		lookifyService.deleteLookify(id);
		return "redirect:/lookify";
	}
	@RequestMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		List<Lookify> lookify = lookifyService.getSearchSongs(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("lookify", lookify);
		return "lookify/search.jsp";
	}
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist;
	}
}
