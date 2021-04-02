package com.codingdojo.java.week1.javafun.javaoop.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.java.week1.javafun.javaoop.loginreg.models.User;
import com.codingdojo.java.week1.javafun.javaoop.loginreg.services.UserService;
import com.codingdojo.java.week1.javafun.javaoop.loginreg.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UserController(UserService userService) {
		this.userService = userService;
		this.userValidator = new UserValidator();
	}
	
	@GetMapping("/")
	public String home(@ModelAttribute("user") User user) {
		return "loginreg.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginreg.jsp";
		}
		else{
			session.setAttribute("user", (Long) userService.registerUser(user).getId());

		
		return "redirect:/home";
		}
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
          if (userService.authenticateUser(email, password)) {
              session.setAttribute("user", (Long) userService.findByEmail(email).getId());
              return "redirect:/home";
          } else {
              redirectAttributes.addFlashAttribute("error",  "Are you sure you are registered");
              model.addAttribute("error", "Not authenticated");
              return "redirect:/";
         }
	}
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
             model.addAttribute("user",userService.findUserById((Long)session.getAttribute("user")));
             return "home.jsp";
	}
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return"redirect:/";
    }
}