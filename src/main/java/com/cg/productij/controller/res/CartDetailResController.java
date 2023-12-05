package com.cg.productij.controller.res;

import com.cg.productij.model.CartDetail;
import com.cg.productij.model.Product;
import com.cg.productij.model.dto.CartDetailCreDto;
import com.cg.productij.model.dto.CartDetailQuantityDto;
import com.cg.productij.repository.CartDetailRepository;
import com.cg.productij.service.cart.CartService;
import com.cg.productij.service.cartDetail.CartDetailService;
import com.cg.productij.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartDetailResController {
    @Autowired
    public CartDetailService cartDetailService;
    @Autowired
    public ProductService productService;
    @Autowired
    public CartService cartService;
    @GetMapping("")
    public ResponseEntity<?> getAllCart(){
        List<CartDetail> cartDetails = cartDetailService.findAll();
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }


    @GetMapping("/cartdt")
    public ResponseEntity<?> getAllCartDetail(){
        List<CartDetail> cartDetails = cartDetailService.findAllByCart_Id(1L);
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> createCart(@RequestBody CartDetailCreDto cartDetailCreDto){
        Product product=productService.findById(cartDetailCreDto.getIdProduct()).get();
        if(cartDetailService.existsByProduct_Id(cartDetailCreDto.getIdProduct())){
            CartDetail cartDetail = cartDetailService.getCartDetailByProduct_Id(cartDetailCreDto.getIdProduct());
            Integer quantityNew = cartDetail.getQuantity() +1;
            BigDecimal total = cartDetail.getAmount().add(product.getPrevPrice());
            cartDetail.setAmount(total);
            cartDetail.setQuantity(quantityNew);
            cartDetailService.save(cartDetail);
        }else{
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(cartService.findById(1L).get())
                .setQuantity(1).setProduct(product).setAmount(product.getPrevPrice());
            cartDetailService.save(cartDetail);
    }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/reduce")
    public ResponseEntity<?> reduceQuantity(@RequestBody CartDetailQuantityDto cartDetailQuantityDto){
        Product product=productService.findById(cartDetailQuantityDto.getIdProduct()).get();
        CartDetail cartDetail= cartDetailService.findById(cartDetailQuantityDto.getIdCartDetail()).get();
        if(cartDetail.getQuantity() > 1){
                CartDetail withdrawQuantity = cartDetailService.getCartDetailByProduct_Id(cartDetailQuantityDto.getIdProduct());
                Integer quantityNew = cartDetail.getQuantity() - 1;
                BigDecimal total = cartDetail.getAmount().subtract(product.getPrevPrice());
                withdrawQuantity.setAmount(total);
                withdrawQuantity.setQuantity(quantityNew);
                cartDetailService.save(cartDetail);
        }else{
            cartDetailService.deleteById(cartDetailQuantityDto.getIdCartDetail());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/add")
    public ResponseEntity<?> addCart(@RequestBody CartDetailQuantityDto cartDetailQuantityDto){
        Product product=productService.findById(cartDetailQuantityDto.getIdProduct()).get();
        CartDetail cartDetail= cartDetailService.findById(cartDetailQuantityDto.getIdCartDetail()).get();

            CartDetail withdrawQuantity = cartDetailService.getCartDetailByProduct_Id(cartDetailQuantityDto.getIdProduct());
            Integer quantityNew = cartDetail.getQuantity() + 1;
            BigDecimal total = cartDetail.getAmount().add(product.getPrevPrice());
            withdrawQuantity.setAmount(total);
            withdrawQuantity.setQuantity(quantityNew);
            cartDetailService.save(cartDetail);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCart(@RequestBody CartDetailQuantityDto cartDetailQuantityDto){

        cartDetailService.deleteById(cartDetailQuantityDto.getIdCartDetail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
