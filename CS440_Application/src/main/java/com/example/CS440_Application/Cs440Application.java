package com.example.CS440_Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping; // Import GetMapping annotation
import org.springframework.web.bind.annotation.RequestParam; // Import RequestParam annotation
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Cs440Application {

	public static void main(String[] args) {
		SpringApplication.run(Cs440Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
