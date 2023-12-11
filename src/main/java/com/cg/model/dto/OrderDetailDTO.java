package com.cg.model.dto;

import com.cg.model.CustomerInfo;
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
    private Integer totalProduct;
    private BigDecimal subTotal;
    private String shipping;
    private BigDecimal totalAmount;
    private String status;
    private CustomerInfoDTO customerInfo;
    

    public OrderDetailDTO(Integer totalProduct, BigDecimal subTotal, String shipping, BigDecimal totalAmount, String status, CustomerInfo customerInfo) {
        this.totalProduct = totalProduct;
        this.subTotal = subTotal;
        this.shipping = shipping;
        this.totalAmount = totalAmount;
        this.status = status;
        this.customerInfo = customerInfo.toCustomerInfoDTO();
    }
}
