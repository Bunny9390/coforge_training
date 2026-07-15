package com.coforge.config;

import com.coforge.model.Customer;
import com.coforge.model.DeliveryAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class BeanConfiguration {

    @Bean(name = "customer1")
    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(101);
        customer.setCustomerName("bunny");
        customer.setEmails(Arrays.asList("bunny@gmail.com", "bunny1@gmail.com"));
        customer.setDeliveryAddress(Arrays.asList(getDeliveryAddress(), getDeliveryAddress2()));
        return customer;
    }

    @Bean(name = "deliveryAddress1")
    public DeliveryAddress getDeliveryAddress() {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setCity("city-1");
        deliveryAddress.setState("state-1");
        return deliveryAddress;
    }

    @Bean(name = "deliveryAddress2")
    public DeliveryAddress getDeliveryAddress2() {
        DeliveryAddress deliveryAddress2 = new DeliveryAddress();
        deliveryAddress2.setCity("city-2");
        deliveryAddress2.setState("state-2");
        return deliveryAddress2;
    }
}
