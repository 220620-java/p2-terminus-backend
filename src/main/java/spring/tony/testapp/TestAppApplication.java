package spring.tony.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.tony.testapp.controllers.UserController;

@SpringBootApplication(scanBasePackages = {"spring.tony"})
public class TestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

}
