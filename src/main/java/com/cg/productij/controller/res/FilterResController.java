package com.cg.productij.controller.res;


import com.cg.productij.model.Product;
import com.cg.productij.repository.ProductRepository;
import com.cg.productij.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;



@RestController
@RequestMapping("/api/filter")
public class FilterResController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProduct(
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "company", required = false) String company,
            @RequestParam(name = "maxPrice", required = false) String maxPrice,
            @RequestParam(name = "minPrice", required = false) String minPrice,
            @RequestParam(name = "color", required = false) String color,
            @RequestParam(name = "search", required = false) String search,
            Pageable pageable
    ){

//        System.out.println("QUERY -----------------------------");
//        Double max = Double.valueOf(maxPrice + "");
//        Double min = Double.valueOf(minPrice + "");
        Page<Product> products = productRepository.filterProduct(category, company,new BigDecimal(maxPrice) ,new BigDecimal(minPrice) , color, search.toLowerCase(), pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
