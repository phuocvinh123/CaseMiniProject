package com.cg.service.cart;

import com.cg.model.Cart;
import com.cg.model.CartDetail;
import com.cg.service.IGeneralService;

import java.util.List;

public interface ICategoryService extends IGeneralService<Cart,Long> {
    List<CartDetail> getAllCartDetail(Cart cart);
}
