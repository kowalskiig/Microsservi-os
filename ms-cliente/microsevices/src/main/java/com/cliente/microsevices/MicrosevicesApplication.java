package com.cliente.microsevices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class MicrosevicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrosevicesApplication.class, args);
	}

}
