package com.in28002.junit.junit002.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}

}
