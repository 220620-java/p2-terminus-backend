package com.revature.dummyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
