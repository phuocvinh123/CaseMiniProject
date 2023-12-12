package com.cg.model;

import com.cg.model.dto.reponse.OrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@Accessors(chain = true)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalProduct;
    private BigDecimal subTotal;
    private String shipping = "Free";
    private BigDecimal totalAmount;
    private String status = "draft";
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerInfo customerInfo;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private Cart cart;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    List<OrderDetail> orderDetails;


    public OrderDTO toOrderDTO(){
        return new OrderDTO().setTotalAmount(totalAmount)
                .setSubTotal(subTotal)
                .setShipping(shipping)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .setCustomerInfo(customerInfo.toCustomerInfoDTO());
    }
}
