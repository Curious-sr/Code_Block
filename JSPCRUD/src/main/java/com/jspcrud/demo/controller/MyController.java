package com.jspcrud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {
		
	@GetMapping(value = "/")
	public String demo() {

		return"student";
	}
	
	@PostMapping(value = "/addStudent")
	public String addStudent() {

		return"student";
	}
	
}
