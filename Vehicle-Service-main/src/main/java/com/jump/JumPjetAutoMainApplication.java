package com.jump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JumPjetAutoMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(JumPjetAutoMainApplication.class, args);
	}

}
