package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

@RestController
public class CrudController {
	
	@GetMapping("/testing")
	String  handler() {
		
		return "Hello World! Welcome to Java Programming......";
	}
	
	@PostMapping("/save")
	public User saveData() {
		User user =new User();
		user.setId(1);
		user.setName("Sudhansu Ranjan Dash");
		user.setCity("Bhubaneswar");
		user.setStatus("Active");
		
		return user;
	
	}
}
