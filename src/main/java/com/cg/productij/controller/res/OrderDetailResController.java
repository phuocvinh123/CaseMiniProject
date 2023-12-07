package com.cg.productij.controller.res;

import com.cg.productij.model.Cart;
import com.cg.productij.model.CartDetail;
import com.cg.productij.model.Order;
import com.cg.productij.model.OrderDetail;
import com.cg.productij.model.dto.OrderDetailCreDto;
import com.cg.productij.service.cart.CartService;
import com.cg.productij.service.cartDetail.CartDetailService;
import com.cg.productij.service.order.OrderService;
import com.cg.productij.service.orderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderDetailResController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    public CartService cartService;
    @Autowired
    public CartDetailService cartDetailService;

    @PostMapping("create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDetailCreDto orderDetailCreDto) {
        Cart cart = cartService.findById(orderDetailCreDto.getIdCart()).get();
        List<CartDetail> cartDetails = cartService.getAllCartDetail(cart);
        Order order = new Order();
        int quantity = 0;
        for (CartDetail cartDetail : cartDetails) {
            quantity += cartDetail.getQuantity();
        }
        order.setSubTotal(orderDetailCreDto.getSubTotal());
        order.setTotalAmount(orderDetailCreDto.getTotalAmount());
        order.setTotalProduct(quantity);
        order.setCart(cart);
        order.setCustomerInfo(cart.getCustomerInfo());
        orderService.save(order);
        Order idOrder = orderService.findById(order.getId()).get();
        for (CartDetail cartDetail : cartDetails) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setAmount(cartDetail.getAmount());
            orderDetail.setProduct(cartDetail.getProduct());
            orderDetail.setQuantity(cartDetail.getQuantity());
            orderDetail.setOrder(idOrder);
            orderDetailService.save(orderDetail);
        }
        cartDetailService.deleteAllByCart_Id(cart.getId());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
