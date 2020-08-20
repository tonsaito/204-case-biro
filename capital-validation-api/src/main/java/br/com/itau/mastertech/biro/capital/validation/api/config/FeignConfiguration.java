package br.com.itau.mastertech.biro.capital.validation.api.config;

import br.com.itau.mastertech.biro.capital.validation.api.service.fallback.CompanyRegistryServiceFallback;
import br.com.itau.mastertech.biro.company.api.model.CompanyMetadataModel;
import feign.Feign;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public Feign.Builder feingBuilder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(CompanyRegistryServiceFallback::new, RuntimeException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
