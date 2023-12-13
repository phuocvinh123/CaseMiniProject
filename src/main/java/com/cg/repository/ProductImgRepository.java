package com.cg.repository;

import com.cg.model.ProductImg;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ProductImgRepository extends JpaRepository<ProductImg,Long> {
    @Transactional
    void deleteProductImgByFileUrl(String fileUrl);
}
