package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;
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

	@GetMapping(value="/create")
	public String create(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", UserRole.values());
		return "/users/createEdit";
	}

	@GetMapping(value="/{id}")
	public String view(@PathVariable long id, Model model) {
		model.addAttribute("user", userRepository.getById(id));
		model.addAttribute("roles", UserRole.values());
		return "/users/createEdit";
	}

	@PostMapping(value="/save")
	public String save(HttpServletRequest request) {
		Optional<String> id = Optional.ofNullable(request.getParameter("id"));
		
		User user = id.isPresent() ? userRepository.getById(Integer.valueOf(id.get())) : new User();
		
		user.setUsername(request.getParameter("username"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		
		List<UserRole> userRoles = new ArrayList<>();
		for (String role : request.getParameterValues("roles")) {
			userRoles.add(UserRole.valueOf(role));
		}
		user.setRoles(userRoles);
		
		// TODO support creating new users by encoding and setting password value
		
		user.save();
		
		return "redirect:/users";
	}

}
