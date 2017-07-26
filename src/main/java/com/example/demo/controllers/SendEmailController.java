package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Email;

@RestController
@RequestMapping("/email")
public class SendEmailController {

	@Autowired private JmsTemplate jmsTemplate;

	@GetMapping
	public String sendEmail(
		@RequestParam(value="to") Optional<String> to,
		@RequestParam(value="body") Optional<String> body
	) {
		jmsTemplate.convertAndSend("mailbox", new Email(to.orElse("me@email.com"), body.orElse("Test")));
		return "Sending an email message...";
	}

}
