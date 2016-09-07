package com.university;

import com.university.entity.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class TeammateApplication {

    @Bean(name = "ISSUEBEAN")
    Task getIssue() {
        return new Task("This is a BEAN", 10);
    }

    public static void main(String[] args) {
        SpringApplication.run(TeammateApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(TeammateApplication.class);
        ctx.refresh();
        Task bean = ctx.getBean(Task.class);
        System.out.println(bean.getStoryPoints());
    }

}
