package com.cg.productij.service.cartDetail;

import com.cg.productij.model.CartDetail;
import com.cg.productij.service.IGeneralService;

import java.util.List;

public interface ICartDetailService extends IGeneralService<CartDetail,Long> {
    boolean existsByProduct_Id(Long idProduct);
    CartDetail getCartDetailByProduct_Id(Long idProduct);
    List<CartDetail> findAllByCart_Id(Long idCart);
    List<CartDetail>deleteAllByCart_Id(Long idCart);
}
