package br.com.itau.mastertech.biro.capital.validation.api.service.fallback;


import br.com.itau.mastertech.biro.capital.validation.api.service.CompanyRegistryService;
import br.com.itau.mastertech.biro.company.api.model.CompanyMetadataModel;

public class CompanyRegistryServiceFallback implements CompanyRegistryService {

    private Exception exception;

    public CompanyRegistryServiceFallback(Exception e){
        this.exception = e;
    }


    @Override
    public CompanyMetadataModel getMetadata(String cnpj) {
        System.out.println("Fallback!");
        return null;
    }
}
