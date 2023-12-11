package com.cg.service.customerInfo;

import com.cg.model.CustomerInfo;
import com.cg.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class CustomerInforService implements ICustomerInfoService{
    @Autowired
    public CustomerInfoRepository customerInfoRepository;
    @Override
    public List<CustomerInfo> findAll() {
        return customerInfoRepository.findAll();
    }

    @Override
    public Optional<CustomerInfo> findById(Long id) {
        return customerInfoRepository.findById(id);
    }

    @Override
    public void save(CustomerInfo customerInfo) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
