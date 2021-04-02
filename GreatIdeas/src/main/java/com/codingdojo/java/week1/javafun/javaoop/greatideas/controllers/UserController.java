package com.codingdojo.java.week1.javafun.javaoop.greatideas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.java.week1.javafun.javaoop.greatideas.models.Idea;
import com.codingdojo.java.week1.javafun.javaoop.greatideas.models.User;
import com.codingdojo.java.week1.javafun.javaoop.greatideas.services.ProjectService;
import com.codingdojo.java.week1.javafun.javaoop.greatideas.validators.UserValidator;

@Controller
public class UserController {
	private final ProjectService pServ;
	private final UserValidator userValidator;
	
	public UserController(ProjectService pServ) {
		this.pServ = pServ;
		this.userValidator = new UserValidator();
	}
	
	@GetMapping("/")
	public String home(@ModelAttribute("user") User user, HttpSession session) {
		session.setAttribute("login", false);
		return "loginreg.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginreg.jsp";
		}
		else{
			session.setAttribute("user", (Long) pServ.registerUser(user).getId());
			session.setAttribute("login", true);

		
		return "redirect:/ideas";
		}
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
          if (pServ.authenticateUser(email, password)) {
        	  session.setAttribute("login", true);
              session.setAttribute("user", (Long) pServ.findByEmail(email).getId());
              return "redirect:/ideas";
          } else {
              redirectAttributes.addFlashAttribute("error",  "Are you sure you are registered");
              model.addAttribute("error", "Not authenticated");
              return "redirect:/";
         }
	}
	@GetMapping("/ideas")
    public String home(HttpSession session, Model model) {
             model.addAttribute("user",pServ.findUserById((Long)session.getAttribute("user")));
            List<Idea> allIdeas=pServ.findAll();
            model.addAttribute("allIdeas", allIdeas);
             return "ideas.jsp";
	}
	@GetMapping("/ideas/new")
	public String createPage(@Valid @ModelAttribute("newidea") Idea newidea) {
		return "new.jsp";
	}
	
	@PostMapping("/ideas/new")
	public String create(@Valid @ModelAttribute("newidea") Idea idea, BindingResult result, HttpSession session, Model model) {
    	model.addAttribute("user", pServ.findUserById((Long)session.getAttribute("user")));
    	if(result.hasErrors()) {
    		return "new.jsp";
    	}else {
    		Long user_id=(Long) session.getAttribute("user");
    		pServ.createIdea(idea, user_id);
    		return "redirect:/ideas";
    	}    		
	}
	@GetMapping("/ideas/{idea_id}")
	public String ideaInfo(@PathVariable("idea_id")Long id, Model model, HttpSession session) {
		if((boolean)session.getAttribute("login") == true) {
			model.addAttribute("idea", pServ.findIdeaById(id));
			model.addAttribute("user", pServ.findUserById((Long)session.getAttribute("user")));
			return "show.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	@GetMapping("ideas/edit/{idea_id}")
	public String editIdea(@ModelAttribute("idea")Idea idea,@PathVariable("idea_id")Long id,Model model,HttpSession session) {
		
		if((boolean)session.getAttribute("login") == true) {
			model.addAttribute("idea",pServ.findIdeaById(id));
			return"edit.jsp";
		}
		else {
			return"redirect:/";
		}
	}
	@PutMapping("/ideas/edit/{id}")
	public String update(@PathVariable("id")Long id, @Valid @ModelAttribute("idea")Idea idea, BindingResult result, HttpSession session, Model model) {
		User user = pServ.findUserById((Long)session.getAttribute("user"));
		if(pServ.findIdeaById(id).getCreator().getId() == user.getId()) {
			if(result.hasErrors()){
				return"edit.jsp";
			}
			else {
//				model.addAttribute("idea", pServ.findIdeaById(id));
//				idea.setId(id);
				idea.setCreator(user);
				pServ.updateIdea(idea);
				return "redirect:/ideas";
			}
		}
		else {
			return "redirect:/";
		}
	}
	@DeleteMapping("/ideas/{idea_id}")
	public String destroy(@PathVariable("idea_id")Long id, HttpSession session) {
		pServ.deleteIdea(id);
		return "redirect:/ideas";
	}
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return"redirect:/";
    }
}

