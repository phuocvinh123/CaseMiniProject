package com.cg.model.dto.reponse;


import com.cg.model.Order;
import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderDetailDTO {
    private OrderDTO order;
    private Product product;
    private Integer quantity;
    private BigDecimal amount;

    public OrderDetailDTO(Order order, Product product, Integer quantity, BigDecimal amount) {
        this.order = order.toOrderDTO();
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }
}
