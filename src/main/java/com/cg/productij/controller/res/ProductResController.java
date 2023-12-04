package com.cg.productij.controller.res;

import com.cg.productij.model.CartDetail;
import com.cg.productij.model.Product;
import com.cg.productij.service.cartDetail.CartDetailService;
import com.cg.productij.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductResController {
    @Autowired
    private IProductService productService;
    @Autowired
    private CartDetailService cartDetailService;
    @GetMapping("")
    public ResponseEntity<?> getAllProduct(){
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
