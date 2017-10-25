package com.uam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class})
public class NasApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasApplication.class, args);
	}
}
