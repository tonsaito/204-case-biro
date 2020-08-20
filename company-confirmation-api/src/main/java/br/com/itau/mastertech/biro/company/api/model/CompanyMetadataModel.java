package br.com.itau.mastertech.biro.company.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyMetadataModel {

    private String name;
    private String cnpj;
    @JsonProperty(value = "capital_social")
    private String capital;

    public BigDecimal getBigDecimalCapital(){
        return new BigDecimal(this.capital);
    }

}
