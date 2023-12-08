package com.cg.productij.controller.res;


import com.cg.productij.model.Category;
import com.cg.productij.model.Color;
import com.cg.productij.model.Product;
import com.cg.productij.service.cartDetail.CartDetailService;
import com.cg.productij.service.category.ICategoryService;
import com.cg.productij.service.color.IColorSevice;
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
    private ICategoryService categoryService;
    @Autowired
    private IColorSevice colorSevice;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/color")
    public ResponseEntity<?> getAllColor() {
        List<Color> colors = colorSevice.findAll();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }
}
