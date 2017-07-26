package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping("/login")
    public String login() {
        return "/login";
    }

	@GetMapping("/logout")
	public String logout() {
		return "/j-security-logout";
	}

	@GetMapping("/")
	public String home() {
		return "/home";
	}

}
