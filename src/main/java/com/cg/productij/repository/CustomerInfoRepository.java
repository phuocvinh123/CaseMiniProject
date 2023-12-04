package com.cg.productij.repository;

import com.cg.productij.model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Long> {
}
