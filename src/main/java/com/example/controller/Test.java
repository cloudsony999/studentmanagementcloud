package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	@GetMapping("/")
	public String hello() {
		return "<h2>Hello Testing 123....</h2>";
	}

}
