package com.ahmed.publishersync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PublishersyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublishersyncApplication.class, args);
	}

}
