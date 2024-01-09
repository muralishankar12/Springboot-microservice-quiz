package com.shankar.serviceDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryQuizApplication.class, args);
	}

}
