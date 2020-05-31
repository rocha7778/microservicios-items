package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviciosItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosItemsApplication.class, args);
	}

}
