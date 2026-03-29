package com.example.object_mapping_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ObjectMappingPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectMappingPracticeApplication.class, args);
	}

}
