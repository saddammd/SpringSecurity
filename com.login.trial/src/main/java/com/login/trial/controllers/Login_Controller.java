package com.login.trial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login_Controller {

	@GetMapping("/show-mylogin")
	public String showLogin()
	
	{
		return "mylogin";
	}
}
