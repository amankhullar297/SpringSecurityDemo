package com.springsecuritydemo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EntityScan("com.springsecuritydemo.entity")
@EnableJpaRepositories("com.springsecuritydemo")
@ComponentScan("com.springsecuritydemo")

public class SpringSecurityDemo {
    public static void main(String[] args){
        SpringApplication.run(SpringSecurityDemo.class,args);
    }
}
