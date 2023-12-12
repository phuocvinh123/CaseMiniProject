package com.cg.model.dto.request;

import com.cg.model.CustomerInfo;
import com.cg.model.CartDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CartDTO {
    private Long id;
    private CustomerInfo customerInfo;
    private List<CartDetail> cartDetail;
}
