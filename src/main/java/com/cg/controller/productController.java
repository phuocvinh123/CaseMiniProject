package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class productController {

    @GetMapping("/product")
    public String showHome(){
        return "/products/product";
    }

    @GetMapping("/cart")
    public String showCart(){
        return "/products/Cart";
    }

@GetMapping("/admin/order")
public String showOrder(){
    return "/admin/order";
}

    @GetMapping("/admin/product-list")
    public String showProductList(){
        return "/admin/product-list";
    }
}
