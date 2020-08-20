package br.com.itau.mastertech.biro.company.api.repository;

import br.com.itau.mastertech.biro.company.api.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {
}
