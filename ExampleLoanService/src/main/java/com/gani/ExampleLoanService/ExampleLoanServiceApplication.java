package com.gani.ExampleLoanService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ExampleLoanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleLoanServiceApplication.class, args);
		System.out.println("http://localhost:8081");
	}
}
