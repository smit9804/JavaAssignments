package com.codingdojo.java.week1.javafun.javaoop.productcategory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.java.week1.javafun.javaoop.productcategory.models.Category;
import com.codingdojo.java.week1.javafun.javaoop.productcategory.models.Product;
import com.codingdojo.java.week1.javafun.javaoop.productcategory.repositories.CRepo;
import com.codingdojo.java.week1.javafun.javaoop.productcategory.repositories.PRepo;
import com.codingdojo.java.week1.javafun.javaoop.productcategory.services.CServ;
import com.codingdojo.java.week1.javafun.javaoop.productcategory.services.PServ;



@Controller
@RequestMapping("/")
public class HomeController {
	private final PServ pServ;
	private final CServ cServ;
	private final PRepo pRepo;
	private final CRepo cRepo;
	
	public HomeController(PServ pServ, CServ cServ, PRepo pRepo, CRepo cRepo) {
		this.pServ = pServ;
		this.cServ = cServ;
		this.pRepo = pRepo;
		this.cRepo = cRepo;
	}

	@RequestMapping("")
	private String redirectIndex() {
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	private String index( 
		Model model
	) {
			List<Product> prodOut = pServ.retrieveAll();
			List<Category> catOut = cServ.retrieveAll();
			model.addAttribute("pList", prodOut);
			model.addAttribute("cList", catOut);
			model.addAttribute("lazy", "index");
			return "dash.jsp";
	}
	@RequestMapping("/new/product")
	public String newProduct(@ModelAttribute("p") Product p, Model model) {
		model.addAttribute("lazy", "newP");
		return "dash.jsp";
	}
	@RequestMapping("/newP")
	public String processNewProduct(@Valid @ModelAttribute("p") Product p, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dash.jsp";
		}
		else {
			pServ.create(p);
			return "redirect:/";
		}
	}	
	@RequestMapping("/new/category")
	public String newProduct(@ModelAttribute("p") Category p, Model model) {
		model.addAttribute("lazy", "newC");
		return "dash.jsp";
	}
	@RequestMapping("/newC")
	public String processNewProduct(@Valid @ModelAttribute("p") Category p, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dash.jsp";
		}
		else {
			cServ.create(p);
			return "redirect:/";
		}
	}
	@RequestMapping("/add/category/{id}")
	public String addCategory(@PathVariable("id") Long id, Model model) {
		Product p = pServ.retrieve(id);
		List<Category> cats = cRepo.findAll();
		model.addAttribute("cList", cats);
		model.addAttribute("pList", p);
		model.addAttribute("lazy", "addC");
		return "dash.jsp";
	}
	@RequestMapping("/addC/{id}")
	public String processCategory(@RequestParam("p") Long c, @PathVariable("id") Long id, Model model) {
		Product prod = pServ.retrieve(id);
		List<Category> cats = prod.getCategories();
		Category cat = cServ.retrieve(c);
		cats.add(cat);
		pRepo.save(prod);
		model.addAttribute("lazy", "addC");
		return "redirect:/add/category/{id}";
	}
	@RequestMapping("/add/product/{id}")
	public String addProduct(@PathVariable("id") Long id, Model model) {
		Category c = cServ.retrieve(id);
		List<Product> prods = pRepo.findAll();
		model.addAttribute("pList", prods);
		model.addAttribute("cList", c);
		model.addAttribute("lazy", "addP");
		return "dash.jsp";
	}
	@RequestMapping("/addP/{id}")
	public String processProduct(@RequestParam("p") Long p, @PathVariable("id") Long id, Model model) {
		Category cat = cServ.retrieve(id);
		List<Product> prods = cat.getProducts();
		Product prod = pServ.retrieve(p);
		prods.add(prod);
		cRepo.save(cat);
		model.addAttribute("lazy", "addP");
		return "redirect:/add/product/{id}";
	}
}
