package com.io.kowalskiig.mscredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MscreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscreditoApplication.class, args);
	}

}
