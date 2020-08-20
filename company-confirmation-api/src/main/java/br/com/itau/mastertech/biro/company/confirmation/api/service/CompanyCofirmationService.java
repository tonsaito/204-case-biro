package br.com.itau.mastertech.biro.company.confirmation.api.service;

import br.com.itau.mastertech.biro.company.api.model.CompanyMetadataModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CompanyCofirmationService {

    @KafkaListener(topics = "spec4-ayrton-saito-3",groupId = "default")
    public void processCompanies(@Payload CompanyMetadataModel companyMetadataModel){
        try{
            System.out.println("Receiving message...");
            System.out.println(companyMetadataModel.getName());
            System.out.println(companyMetadataModel.getCnpj());
            System.out.println(companyMetadataModel.getCapital());
            FileWriter fileWriter = new FileWriter("federatedCompanies.csv", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            StringBuilder sb = new StringBuilder();
            sb.append("name,");
            sb.append("cnpj,");
            sb.append("capital,");
            sb.append('\n');

            sb.append(companyMetadataModel.getName());
            sb.append(',');
            sb.append(companyMetadataModel.getCnpj());
            sb.append(',');
            sb.append(companyMetadataModel.getCapital());
            sb.append('\n');

            printWriter.write(sb.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
