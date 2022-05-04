package com.swiggy.swiggy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SwiggyApplication {

	public static void main(String[] args) {

//		SpringApplication.run(SwiggyApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(SwiggyApplication.class, args);

		DataPopulator.setUp();

	}

}
