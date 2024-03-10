package com.ipl.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableEurekaClient
@SpringBootApplication()
public class CdpAlertServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(CdpAlertServiceApplication.class, args);
	}

}
