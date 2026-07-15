package com.coforge.main;

import com.coforge.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee employee1 = (Employee) context.getBean("employee1");
        System.out.println(employee1);
        Employee employee2 = (Employee) context.getBean("employee2");
        System.out.println(employee2);
    }
}

//output
// Employee [eid=1, ename=John Doe, esalary=50000.0, edepartment=IT, eemail=john.doe@company.com]
// Employee [eid=2, ename=Jane Smith, esalary=60000.0, edepartment=HR, eemail=jane.smith@company.com]