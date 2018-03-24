package com.aandres.email.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aandres.emailservice.register.model.dto.SubscriptionDTO;
import org.springframework.http.HttpStatus;
@RestController
public class EmailController {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmailController.class);
	
	
	@PostMapping(value = "/email", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void event(
			@RequestBody SubscriptionDTO subscription) throws Exception {
		log.info("subscription: {}", subscription);
	}


}
