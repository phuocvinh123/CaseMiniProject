package com.cg.productij.model.dto;

import com.cg.productij.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailCreDto {
    private BigDecimal subTotal;
    private BigDecimal totalAmount;
    private Long idCart;
}
