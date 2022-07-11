package com.demo.springbootlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootLoggingApplication {

	Logger log = LoggerFactory.getLogger(SpringbootLoggingApplication.class);

	@GetMapping("/test/{name}")
	public String sayHello(@PathVariable String name) {
		log.debug("Request {}", name);

		//testing exception flow
		if (name.equalsIgnoreCase("test")) {
			throw new RuntimeException("Exception raised..........");
		}
		String response = "Hello " + name;
		log.debug("Response {}", response);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLoggingApplication.class, args);
	}

}
