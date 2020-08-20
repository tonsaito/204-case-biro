package br.com.itau.mastertech.biro.company.api.controller;

import br.com.itau.mastertech.biro.company.api.entity.CompanyEntity;
import br.com.itau.mastertech.biro.company.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyEntity> saveCompanyV1(@RequestBody CompanyEntity companyEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(companyEntity));
    }
}
