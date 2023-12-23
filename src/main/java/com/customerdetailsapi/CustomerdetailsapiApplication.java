package com.customerdetailsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.customerdetailsapi.Repository")
public class CustomerdetailsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerdetailsapiApplication.class, args);
	}

}
