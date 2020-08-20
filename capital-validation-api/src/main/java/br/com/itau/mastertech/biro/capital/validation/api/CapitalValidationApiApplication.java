package br.com.itau.mastertech.biro.capital.validation.api;

import br.com.itau.mastertech.biro.capital.validation.api.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class CapitalValidationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalValidationApiApplication.class, args);
	}

}
