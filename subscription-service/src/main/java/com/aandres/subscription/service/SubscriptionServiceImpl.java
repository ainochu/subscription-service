package com.aandres.subscription.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aandres.subscription.repository.SubscriptionRepository;
import com.aandres.subscriptionservice.common.exception.SubscriptionException;
import com.aandres.subscriptionservice.common.model.dto.ResponseCode;
import com.aandres.subscriptionservice.register.model.dto.RegisterDTO;
import com.aandres.subscriptionservice.subscription.model.Subscription;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;
import com.aandres.subscription.service.SubscriptionDTOMapper;
import com.aandres.subscription.service.SubscriptionMapper;


@SpringBootApplication
public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static final Logger log = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

	@Autowired
	public SubscriptionRepository subscriptionRepository;
	
//	@Autowired
//	public SubscriptionMapper subscriptionMapper;
	
//	@Autowired
//	public SubscriptionDTOMapper subscriptionDTOMapper;
	
	public SubscriptionDTO create(RegisterDTO subscription) throws SubscriptionException{
		SubscriptionMapper subscriptionMapper = new SubscriptionMapper();
		SubscriptionDTOMapper subscriptionDTOMapper = new SubscriptionDTOMapper();
		Subscription subscriptionNew = subscriptionMapper.map(subscription, Subscription.class);
		//Check if exists other user with the same email
		if ((subscriptionRepository.findByEmail(subscriptionNew.getEmail()) != null)){
			throw new SubscriptionException(ResponseCode.EMAIL_EXISTS);
		}
		subscriptionNew.setCampaignId(1L);
		subscriptionNew = subscriptionRepository.save(subscriptionNew);
		return subscriptionDTOMapper.map(subscriptionNew, SubscriptionDTO.class);
	}

	


}
