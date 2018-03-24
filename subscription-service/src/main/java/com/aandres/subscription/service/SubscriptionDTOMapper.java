package com.aandres.subscription.service;
import com.aandres.subscriptionservice.subscription.model.Subscription;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class SubscriptionDTOMapper extends ConfigurableMapper {
	
	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(Subscription.class, SubscriptionDTO.class).byDefault().register();
	}

}
