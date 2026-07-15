package com.coforge.com.coforge.config;

import com.coforge.com.coforge.model.Address;
import com.coforge.com.coforge.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
public class BeanConfiguration {

    @Bean
    public Address address() {
        return new Address("New York", "NY");
    }

    @Bean
    public Student student() {
        List<String> subjects = Arrays.asList("Math", "Science", "History");
        Set<String> skills = new HashSet<>(Arrays.asList("Java", "Spring", "SQL"));
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", 90);
        marks.put("Science", 85);
        marks.put("History", 95);

        return new Student(1, "John Doe", address(), subjects, skills, marks);
    }
}
