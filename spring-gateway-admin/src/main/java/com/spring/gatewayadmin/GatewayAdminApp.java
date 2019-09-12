package com.spring.gatewayadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class GatewayAdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(GatewayAdminApp.class, args);
		
	}

}
