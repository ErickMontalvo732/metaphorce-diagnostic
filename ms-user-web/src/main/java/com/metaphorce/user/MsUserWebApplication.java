package com.metaphorce.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MsUserWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUserWebApplication.class, args);
	}

}
