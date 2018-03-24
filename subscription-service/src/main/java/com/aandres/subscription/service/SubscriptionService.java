package com.aandres.subscription.service;

import com.aandres.subscriptionservice.common.exception.SubscriptionException;
import com.aandres.subscriptionservice.register.model.dto.RegisterDTO;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;

public interface SubscriptionService {
	
	SubscriptionDTO create(RegisterDTO subscription) throws SubscriptionException;
	
}
