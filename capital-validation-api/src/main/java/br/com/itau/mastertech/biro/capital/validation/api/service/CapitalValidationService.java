package br.com.itau.mastertech.biro.capital.validation.api.service;

import br.com.itau.mastertech.biro.company.api.model.CompanyMetadataModel;
import br.com.itau.mastertech.biro.company.api.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CapitalValidationService {

    @Autowired
    private KafkaTemplate<String, CompanyMetadataModel> producer;

    @Autowired
    private CompanyRegistryService companyRegistryService;

    @KafkaListener(topics = "spec4-ayrton-saito-2", groupId = "defaut")
    public void processMessageValidateCompaniesRegistration(@Payload CompanyModel companyModel){
        System.out.println("Receiving message...");
        System.out.println(companyModel.getName());
        System.out.println(companyModel.getCnpj());
        CompanyMetadataModel companyMetadataModel = companyRegistryService.getMetadata(companyModel.getCnpj());
        if(companyMetadataModel.getBigDecimalCapital().compareTo(new BigDecimal(1000000.00)) == 1){{
            companyMetadataModel.setName(companyModel.getName());
            companyMetadataModel.setCnpj(companyModel.getCnpj());
            producer.send("spec4-ayrton-saito-3", companyMetadataModel);
        }}
    }

}
