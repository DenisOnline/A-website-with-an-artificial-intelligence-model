package ru.monkeyTeam.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ArtificialIntelligenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtificialIntelligenceApplication.class, args);
	}

}
