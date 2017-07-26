package com.example.demo.receivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.Email;

@Component
public class EmailReceiver {

	@JmsListener(destination="mailbox", containerFactory="jmsContainerFactory")
	public void receiveEmail(Email email) {
		System.out.println("Received <" + email + ">");
	}

}
