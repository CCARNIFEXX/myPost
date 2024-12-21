package com.micro.mypost.personacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class PersonAccApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonAccApplication.class, args);
    }

}
