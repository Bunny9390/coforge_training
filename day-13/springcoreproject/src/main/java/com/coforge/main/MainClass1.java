package com.coforge.main;

import com.coforge.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer1 = (Customer) context.getBean("customer1");
        System.out.println(customer1);

    }
}
// output
// Customer [customerId=101, customerName=bunny, emails=[bunny@gmail.com, bunny1@gmail.com], deliveryAdress=[Address [city=city-1, state=state-1], Address [city=city-2, state=state-2]]]