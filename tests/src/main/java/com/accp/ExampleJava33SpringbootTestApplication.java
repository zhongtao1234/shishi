package com.accp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.accp")
public class ExampleJava33SpringbootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleJava33SpringbootTestApplication.class, args);
	}

}
