package com.micro.mypost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.micro.mypost.postgres.*")
@EnableJpaRepositories(basePackages = {
        "com.micro.mypost.postgres.*"})
@SpringBootApplication(scanBasePackages = {
        "com.micro.mypost"})
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

}
