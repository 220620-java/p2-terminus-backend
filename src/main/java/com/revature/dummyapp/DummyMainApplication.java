package com.revature.dummyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Team Terminus
 *
 */
@SpringBootApplication(scanBasePackages = {"com.revature"})
public class DummyMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyMainApplication.class, args);
	}
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.exposedHeaders("*")
						.allowCredentials(false)
						.maxAge(3600);
			}
			
		};
	}

}
