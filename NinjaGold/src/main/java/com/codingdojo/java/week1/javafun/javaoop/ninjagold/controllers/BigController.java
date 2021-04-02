package com.codingdojo.java.week1.javafun.javaoop.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BigController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/monies", method=RequestMethod.POST)
	
	public String build(@RequestParam(value="process") String process, HttpSession session) {
		String time = new SimpleDateFormat ("EEE, MMM d, ''yy, h:mm a").format(new Date());
		if (process.equals("farm")) {
			int num = ThreadLocalRandom.current().nextInt(10, 20+1);
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold",  gold+num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, "You farmed that corn and got " +num+ " gold. ("+time+")");
		}
		if(process.equals("cave")) {
			int num = ThreadLocalRandom.current().nextInt(5, 10 +1);
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", gold+num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0,"You went into that dark cave and found " +num+ " gold. ("+time+")");
		}
		if(process.equals("house")) {
			int num = ThreadLocalRandom.current().nextInt(5, 10 +1);
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", gold+num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0,"You got a house and got " +num+ " gold. ("+time+")");
		}
		if(process.equals("casino")) {
			int num = ThreadLocalRandom.current().nextInt(-50, 50 +1);
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", gold+num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			if (num>0) {
			activities.add(0,"You went into the casino and won " +num+ " gold. ("+time+")");
			}
			else {
				activities.add(0, "You entered a casino and lost "+num+" gold. ("+time+")");
			}
			
		}
		return "redirect:/";
	}
}