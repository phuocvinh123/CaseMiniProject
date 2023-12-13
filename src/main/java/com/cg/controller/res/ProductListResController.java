package com.cg.controller.res;

import com.cg.model.Product;
import com.cg.model.dto.reponse.ProductRepDTO;
import com.cg.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-list")
public class ProductListResController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductRepDTO productRepDTO) {
        Product product =productRepDTO.toProduct();

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
