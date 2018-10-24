package com.gotoevent.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.gotoevent.api.entity")
public class GotoeventApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotoeventApiApplication.class, args);
	}
}
