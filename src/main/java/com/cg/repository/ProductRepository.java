package com.cg.repository;

import com.cg.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Query("SELECT p FROM Product p " +
//            "WHERE (:category = 'all' OR LOWER(p.category.nameCategory) = LOWER(:category)) " +
//            "AND ((:minPrice = 0.0 AND :maxPrice = 0.0) OR (:minPrice = :maxPrice AND :minPrice > 0.0 AND p.newPrice >= :minPrice) OR (:minPrice <= p.newPrice AND p.newPrice > :maxPrice)) " +
//            "AND (:color = 'all' OR LOWER(p.color.nameColor) = LOWER(:color)) " +
//            "AND (:company = 'all' OR LOWER(p.company.nameCompany) = LOWER(:company)) " +
//            "AND (p.title LIKE LOWER(CONCAT('%', :search, '%')))")
//    Page<Product> filterProduct(
//            @Param("category") String category,
//            @Param("company") String company,
//            @Param("maxPrice") BigDecimal maxPrice,
//            @Param("minPrice") BigDecimal minPrice,
//            @Param("color") String color,
//            @Param("search") String search,
//            Pageable pageable);

    @Query("SELECT p FROM Product p " +
            "WHERE (:category = 'all' OR p.category.nameCategory = :category) " +
            "AND (:minPrice <= p.newPrice) " +
            "AND (:maxPrice > p.newPrice) " +
            "AND (:color = 'all' OR p.color.nameColor = :color) " +
            "AND (:company = 'all' OR p.company.nameCompany = :company) " +
            "AND (LOWER(p.title) LIKE CONCAT('%', :search, '%'))")
    Page<Product> filterProduct(
            @Param("category") String category,
            @Param("company") String company,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("minPrice") BigDecimal minPrice,
            @Param("color") String color,
            @Param("search") String search,
            Pageable pageable);
}

