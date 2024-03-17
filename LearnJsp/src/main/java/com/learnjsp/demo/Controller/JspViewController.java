package com.learnjsp.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspViewController {
	
	@GetMapping(value = "/")
	public String demo() {

		return"Student";
	}
}
