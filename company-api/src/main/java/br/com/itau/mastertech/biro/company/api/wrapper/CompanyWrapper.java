package br.com.itau.mastertech.biro.company.api.wrapper;

import br.com.itau.mastertech.biro.company.api.entity.CompanyEntity;
import br.com.itau.mastertech.biro.company.api.model.CompanyModel;

public class CompanyWrapper {

    private CompanyWrapper(){}

    public static CompanyModel toCompanyModel(CompanyEntity companyEntity){
        return new CompanyModel(companyEntity.getName(), companyEntity.getCnpj());
    }
}
