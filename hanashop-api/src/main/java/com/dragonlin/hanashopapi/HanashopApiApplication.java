package com.dragonlin.hanashopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HanashopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HanashopApiApplication.class, args);
	}

}
