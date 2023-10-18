package com.javapractice.javapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class JavapracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavapracticeApplication.class, args);
	}

}

@RestController
class HelloController {

	@GetMapping("/")
	public String hello() {
		return "Hello, World 6!";
	}
}