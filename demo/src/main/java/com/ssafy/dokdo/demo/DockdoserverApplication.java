package com.ssafy.dokdo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ConfigurationPropertiesScan("com.ssafy.dokdo.demo")
public class DockdoserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockdoserverApplication.class, args);
	}

}
