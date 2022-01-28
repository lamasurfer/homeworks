package com.example.rest;

import com.example.rest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    CommandLineRunner addUsers(UserRepository repository) {
        return args -> {
            repository.addUser("alex", "1111");
            repository.addUser("john", "2222");
        };
    }
}
