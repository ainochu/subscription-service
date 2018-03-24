package com.aandres.subscription.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.aandres.subscriptionservice.subscription.model.Subscription;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;

public interface SubscriptionRepository extends Repository<Subscription, Long>{
	
	Subscription save(Subscription subscription);
	Subscription findByEmail(String email);
	
	
	

}
