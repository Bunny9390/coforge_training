package com.coforge.main;

import com.coforge.config.BeanConfiguration;
import com.coforge.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Customer customer1 = context.getBean("customer1", Customer.class);
        System.out.println(customer1);
    }
}
// output
// Customer [customerId=101, customerName=bunny, emails=[bunny@gmail.com, bunny1@gmail.com], deliveryAdress=[Address [city=city-1, state=state-1], Address [city=city-2, state=state-2]]]