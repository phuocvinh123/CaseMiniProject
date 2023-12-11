package com.cg.repository;

import com.cg.model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Long> {
}
