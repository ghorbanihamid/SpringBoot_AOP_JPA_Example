package com.soshiant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootAppExample {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootAppExample.class);
	public static void main(String[] args) {


        logger.info("Starting Spring Boot Example.");

		SpringApplication.run(SpringBootAppExample.class, args);
	}
}
