package com.cg.productij.service.company;

import com.cg.productij.model.Company;
import com.cg.productij.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class CompanyService implements ICompanyService{
    @Autowired
    public CompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public void save(Company company) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
