package com.aandres.subscription.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aandres.subscription.gender.model.Gender;
import com.aandres.subscriptionservice.SubscriptionServiceApplication;
import com.aandres.subscriptionservice.common.exception.SubscriptionException;
import com.aandres.subscriptionservice.register.model.dto.RegisterDTO;
import com.aandres.subscriptionservice.subscription.model.dto.SubscriptionDTO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SubscriptionServiceApplication.class})
public class SubscriptionServiceTest {
	
    @Autowired
    SubscriptionService subscriptionService;

    @Test
    public void test_subscription_service_always_return_subscriptionDTO() throws SubscriptionException {

        //assert correct type/impl
        assertThat(subscriptionService, instanceOf(SubscriptionServiceImpl.class));

        RegisterDTO dto =  new RegisterDTO();
        dto.setEmail("user@test.com");
        dto.setFirstName("aandres");
        dto.setGender("FEMALE");
        dto.setDateOfBirth(new Date("2018-12-05"));
        
        //assert true
        assertThat(subscriptionService.create(dto), instanceOf(SubscriptionDTO.class));

    }

}
