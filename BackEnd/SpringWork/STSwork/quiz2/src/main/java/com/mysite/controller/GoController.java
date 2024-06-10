package com.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class GoController {
	
	@GetMapping("/go")
	public String go() {
		return "go";
	}
	
	@PostMapping("/gogo")
	public String gogo(String destination, Model model) {
		model.addAttribute("destination", destination);
		return "gogo";
	}
}
