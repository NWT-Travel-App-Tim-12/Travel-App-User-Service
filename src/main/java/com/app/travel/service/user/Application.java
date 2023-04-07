package com.app.travel.service.user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition
public class Application {
 // comm
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
