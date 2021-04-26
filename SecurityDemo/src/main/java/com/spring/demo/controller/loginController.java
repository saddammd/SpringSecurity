package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

	@GetMapping("/showmylogin")
	public String myLogin() {
		
		return "custom-login";
	}
	
}
