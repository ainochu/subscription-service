package com.aandres.subscription.controller;

import java.lang.annotation.Repeatable;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aandres.subscription.service.SubscriptionService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import com.aandres.subscriptionservice.common.exception.SubscriptionException;
import com.aandres.subscriptionservice.common.model.dto.ErrorResultDTO;
import com.aandres.subscriptionservice.common.model.dto.ResponseCode;
import com.aandres.subscriptionservice.register.model.dto.RegisterDTO;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "susbcribe",tags = "Subscription API")
public class SubscriptionController {
	
	@Autowired
	public SubscriptionService subscriptionService;

	
	private static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);
	
	@PostMapping(value = "/subscribe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Suscribe user into newsletter", response = SubscriptionDTO.class)
	public ResponseEntity<SubscriptionDTO> create(
			@RequestBody @Valid RegisterDTO subscription) throws SubscriptionException {
		log.info("subscription: {}", subscription);
		SubscriptionDTO subscriptionCreated = subscriptionService.create(subscription);
		log.info("Response {}", subscriptionCreated);
		return new ResponseEntity<>(subscriptionCreated, HttpStatus.CREATED);
	}
	
	@ExceptionHandler({SubscriptionException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResultDTO handleRegisterException(HttpServletRequest req, Exception e) {
		SubscriptionException exception = (SubscriptionException) e;
		return exception.getErrorResultDTO();
    }
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResultDTO handleValidatorException(HttpServletRequest req, Exception e) {
		MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
		return new ErrorResultDTO(exception.getMessage());
    }
	
	


}
