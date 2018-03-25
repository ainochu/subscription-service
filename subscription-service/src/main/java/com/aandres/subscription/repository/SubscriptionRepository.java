package com.aandres.subscription.repository;

import org.springframework.data.repository.Repository;

import com.aandres.subscriptionservice.subscription.model.Subscription;

public interface SubscriptionRepository extends Repository<Subscription, Long>{
	
	Subscription save(Subscription subscription);
	Subscription findByEmail(String email);
	
	
	

}
