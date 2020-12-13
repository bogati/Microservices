package com.jump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//client side load balancer it comes with Ribon + Eureka 
@EnableFeignClients
public class WorkManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkManagementServiceApplication.class, args);
	}

}
