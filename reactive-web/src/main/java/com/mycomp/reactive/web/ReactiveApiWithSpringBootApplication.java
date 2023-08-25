package com.mycomp.reactive.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.mycomp.reactive.*"})
//@EntityScan(basePackages = {"com.mycomp.reactive.*"})
public class ReactiveApiWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApiWithSpringBootApplication.class, args);
	}

}
