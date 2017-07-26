package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired private UserRepository userRepository;

	@GetMapping()
	public String queryDatabase(Model model) {
		model.addAttribute("users", userRepository.getAll());
		return "/users/list";
	}

	@GetMapping(value="/{id}")
	public String view(@PathVariable long id, Model model) {
		model.addAttribute("user", userRepository.getById(id));
		return "/users/createEdit";
	}

	@GetMapping(value="/save")
	public String save(
		@RequestParam(value="firstName") String firstName,
		@RequestParam(value="lastName") String lastName
	) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.save();
		return "redirect:/users/" + user.getId();
	}

}
