package com.abl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com.abl")
public class ServerApplication {
	    
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		while (true) {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	           e.printStackTrace();
	        }
	    }
	}

}

