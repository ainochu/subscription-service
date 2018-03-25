package com.aandres.subscription.service;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.aandres.subscriptionservice.subscription.model.Subscription;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class SubscriptionDTOMapper extends ConfigurableMapper {
	
	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(Subscription.class, SubscriptionDTO.class).byDefault().register();
	}

}
