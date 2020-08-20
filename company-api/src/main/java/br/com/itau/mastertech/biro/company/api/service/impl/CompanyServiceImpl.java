package br.com.itau.mastertech.biro.company.api.service.impl;

import br.com.itau.mastertech.biro.company.api.entity.CompanyEntity;
import br.com.itau.mastertech.biro.company.api.model.CompanyModel;
import br.com.itau.mastertech.biro.company.api.repository.CompanyRepository;
import br.com.itau.mastertech.biro.company.api.service.CompanyService;
import br.com.itau.mastertech.biro.company.api.wrapper.CompanyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private KafkaTemplate<String, CompanyModel> producer;

    @Override
    public CompanyEntity save(CompanyEntity companyEntity) {
        companyEntity = companyRepository.save(companyEntity);
        producer.send("spec4-ayrton-saito-2", CompanyWrapper.toCompanyModel(companyEntity));
        return companyEntity;
    }
}
