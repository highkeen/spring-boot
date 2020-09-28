package com.highken.training.bootlearn.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	public String welcome(@RequestParam(required = false,name = "name")String name, Model model) {
		model.addAttribute("name", Optional.ofNullable(name).orElse("Default"));
		return "welcome_view";
	}
	
	@GetMapping("/{name}")
	public String welcomePath(@PathVariable("name")String name, Model model) {
		model.addAttribute("name", name);
		return "welcome_view";
	}
	
}
