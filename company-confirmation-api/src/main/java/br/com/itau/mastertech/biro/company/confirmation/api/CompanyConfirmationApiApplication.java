package br.com.itau.mastertech.biro.company.confirmation.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompanyConfirmationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyConfirmationApiApplication.class, args);
	}

}
