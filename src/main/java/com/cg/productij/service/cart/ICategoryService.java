package com.cg.productij.service.cart;

import com.cg.productij.model.Cart;
import com.cg.productij.model.CartDetail;
import com.cg.productij.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryService extends IGeneralService<Cart,Long> {
    List<CartDetail> getAllCartDetail(Cart cart);
}
