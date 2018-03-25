package com.aandres.subscription.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.aandres.subscription.repository.SubscriptionRepository;
import com.aandres.subscriptionservice.common.exception.SubscriptionException;
import com.aandres.subscriptionservice.common.model.dto.ResponseCode;
import com.aandres.subscriptionservice.register.model.dto.RegisterDTO;
import com.aandres.subscriptionservice.subscription.model.Subscription;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;
import com.aandres.subscription.service.SubscriptionDTOMapper;
import com.aandres.subscription.service.SubscriptionMapper;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static final Logger log = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

	@Autowired
	public SubscriptionRepository subscriptionRepository;
	
	@Value("${eventservice.url}")
	private String eventServiceUrl;

	@Value("${emailservice.url}")
	private String emailServiceUrl;
	
	@Autowired
	public SubscriptionMapper subscriptionMapper;
	
	@Autowired
	public SubscriptionDTOMapper subscriptionDTOMapper;
	
	public SubscriptionDTO create(RegisterDTO subscription) throws SubscriptionException{
		Subscription subscriptionNew = subscriptionMapper.map(subscription, Subscription.class);
		//Check if exists other user with the same email
		if ((subscriptionRepository.findByEmail(subscriptionNew.getEmail()) != null)){
			throw new SubscriptionException(ResponseCode.EMAIL_EXISTS);
		}
		subscriptionNew.setCampaignId(1L);
		//Call to events service
		callEvents(subscriptionDTOMapper.map(subscription, SubscriptionDTO.class));
		subscriptionNew = subscriptionRepository.save(subscriptionNew);
		return subscriptionDTOMapper.map(subscriptionNew, SubscriptionDTO.class);
	}
	
	private void callEvents(SubscriptionDTO subscriptionCreated) throws SubscriptionException{
	    HttpEntity<SubscriptionDTO> request = new HttpEntity<SubscriptionDTO>(subscriptionCreated);
	    RestTemplate restTemplate = new RestTemplate();
	    log.info("Calling event service with url {0}", emailServiceUrl);
	    try {
	    	restTemplate.exchange(eventServiceUrl, HttpMethod.POST,request, String.class);
	    }catch(Exception e) {
	    	throw new SubscriptionException(ResponseCode.SERVICE_EVENT_EXCEPTION);
	    }
	    log.info("Calling email service with url {0}", emailServiceUrl);
	    try {
	    	restTemplate.exchange(emailServiceUrl, HttpMethod.POST,request, String.class);
	    }catch(Exception e) {
	    	throw new SubscriptionException(ResponseCode.SERVICE_EMAIL_EXCEPTION);
	    }
	}

	


}
