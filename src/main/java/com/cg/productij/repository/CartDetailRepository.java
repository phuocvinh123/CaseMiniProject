package com.cg.productij.repository;

import com.cg.productij.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail,Long> {
    boolean existsByProduct_Id(Long idProduct);
    CartDetail getCartDetailByProduct_Id(Long idProduct);
    List<CartDetail>findAllByCart_Id(Long idCart);
    List<CartDetail>deleteAllByCart_Id(Long idCart);
}
