package com.app.travel.service.user;

import com.app.travel.service.user.interceptors.LoggingInterceptor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition
public class Application {

	@Bean
	public LoggingInterceptor myCustomHandlerInterceptor() {
		return new LoggingInterceptor();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
