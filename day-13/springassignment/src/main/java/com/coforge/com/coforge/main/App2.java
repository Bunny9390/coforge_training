package com.coforge.com.coforge.main;

import com.coforge.com.coforge.config.BeanConfiguration;
import com.coforge.com.coforge.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Student student = context.getBean("student", Student.class);
        student.displayStudentDetails();
    }
}
