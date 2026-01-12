package com.als.pkg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all")
public class ALSController {
	

	@GetMapping("/msg")
	public String  m1() {
		
		return "Hiii Welcome Back";
	}
}
