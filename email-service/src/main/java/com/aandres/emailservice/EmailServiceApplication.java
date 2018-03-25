package com.aandres.emailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.aandres.email.controller.EmailController;

@SpringBootApplication
@ComponentScan(basePackages = {"hello","com.aandres.event.controller","com.aandres.event.mapper"})
@EntityScan("com.aandres.eventservice.subscription.model")
@ComponentScan(basePackageClasses=EmailController.class)
public class EmailServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EmailServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
		log.info("EventService started");

	}

}
