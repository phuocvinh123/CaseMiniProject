package com.cg.productij.service.product;

import com.cg.productij.model.Filter;
import com.cg.productij.model.Product;
import com.cg.productij.model.dto.FilterDTO;
import com.cg.productij.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductService implements IProductService {
    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> filterProduct(String category, String company, Long maxPrices, Long minPrices, String color, String search, Pageable pageable) {
        BigDecimal maxPrice = new BigDecimal(maxPrices);
        BigDecimal minPrice = new BigDecimal(minPrices);
        return productRepository.filterProduct(category, company, maxPrice, minPrice, color, search, pageable);
    }
}
