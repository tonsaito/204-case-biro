package br.com.itau.mastertech.biro.capital.validation.api.service;

import br.com.itau.mastertech.biro.company.api.model.CompanyMetadataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "receitaws" , url = "https://www.receitaws.com.br/v1")
public interface CompanyRegistryService {

    @GetMapping("/cnpj/{cnpj}")
    CompanyMetadataModel getMetadata(@PathVariable String cnpj);
}
