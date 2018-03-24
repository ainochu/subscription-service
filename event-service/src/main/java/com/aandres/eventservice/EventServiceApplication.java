package com.aandres.eventservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aandres.event.controller.EventController;

@SpringBootApplication
@ComponentScan(basePackageClasses=EventController.class)
public class EventServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EventServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
		log.info("EventService started");

	}

}
