package com.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableAsync
public class TeammateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeammateApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    }

}
