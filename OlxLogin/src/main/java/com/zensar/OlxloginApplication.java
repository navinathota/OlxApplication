package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
@ComponentScan(basePackages= {"com.zensar"})
public class OlxloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxloginApplication.class, args);
		
			 
	}

}
