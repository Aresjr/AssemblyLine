package com.example.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AssemblyLineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssemblyLineApplication.class, args);
	}

}
