package com.leron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.leron.models"})
public class SpringBootLoginBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginBackendApplication.class, args);
	}

}
