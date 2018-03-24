package com.aandres.subscription.service;

import javax.persistence.MappedSuperclass;

import com.aandres.subscriptionservice.register.model.dto.RegisterDTO;
import com.aandres.subscriptionservice.subscription.model.Subscription;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class SubscriptionMapper extends ConfigurableMapper {
	
	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(RegisterDTO.class, Subscription.class).byDefault().register();
	}

}
