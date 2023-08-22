package com.faas.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongoRepositories
@EnableJpaRepositories
@EnableScheduling
public class ServerCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerCoreApplication.class, args);
    }

}
