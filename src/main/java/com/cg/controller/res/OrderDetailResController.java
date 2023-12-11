package com.cg.controller.res;

import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.model.dto.OrderDetailDTO;
import com.cg.model.Cart;
import com.cg.model.CartDetail;
import com.cg.model.dto.OrderDetailCreDTO;
import com.cg.service.cart.CartService;
import com.cg.service.cartDetail.CartDetailService;
import com.cg.service.order.OrderService;
import com.cg.service.orderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<?> showOrderList(){
        List<OrderDetailDTO> orders =orderService.getAllOrderDetailDTO();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDetailCreDTO orderDetailCreDto) {
        Cart cart = cartService.findById(orderDetailCreDto.getIdCart()).get();
//        List<CartDetail> cartDetails = cartService.getAllCartDetail(cart);
        List<CartDetail> cartDetails = cart.getCartDetail();
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
