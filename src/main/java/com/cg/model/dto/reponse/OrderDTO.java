package com.cg.model.dto.reponse;

import com.cg.model.CustomerInfo;
import com.cg.model.dto.request.CustomerInfoDTO;
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
public class OrderDTO {
    private Integer totalProduct;
    private BigDecimal subTotal;
    private String shipping;
    private BigDecimal totalAmount;
    private String status;
    private CustomerInfoDTO customerInfo;

    

    public OrderDTO(Integer totalProduct, BigDecimal subTotal, String shipping, BigDecimal totalAmount, String status, CustomerInfo customerInfo) {
        this.totalProduct = totalProduct;
        this.subTotal = subTotal;
        this.shipping = shipping;
        this.totalAmount = totalAmount;
        this.status = status;
        this.customerInfo = customerInfo.toCustomerInfoDTO();
    }
}
