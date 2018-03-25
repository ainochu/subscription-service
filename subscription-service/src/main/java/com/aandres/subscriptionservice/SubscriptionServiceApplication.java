package com.aandres.subscriptionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aandres.subscription.controller.SubscriptionController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.aandres.subscription.controller","com.aandres.subscription.service","com.aandres.subscription.swagger.configuration"})
@EntityScan({"com.aandres.subscriptionservice.subscription.model"})
@EnableJpaRepositories("com.aandres.subscription.repository")
@ComponentScan(basePackageClasses=SubscriptionController.class)
public class SubscriptionServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SubscriptionServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
		log.info("SubscriptionService started");

	}

}
