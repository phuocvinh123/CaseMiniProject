package com.cg.repository;

import com.cg.model.Cart;
import com.cg.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT cd FROM CartDetail cd WHERE cd.cart = :cart")
    List<CartDetail> getAllCartDetail(Cart cart);

    Cart findCartByCustomerInfo_Id(Long id);

}
