package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class GreetingController {

	@GetMapping
	public String hello(Model model) {
		model.addAttribute("name", "World");
		return "greeting";
	}

	@GetMapping("/{name}")
	public String hello(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
