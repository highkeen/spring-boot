package com.highken.training.bootlearn.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String satHello() {
		return "hello";
	}
	
	@GetMapping("/123")
	public String satHello123() {
		return "hello123";
	}
}
