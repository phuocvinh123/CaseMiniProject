package com.cg.service.cart;

import com.cg.model.Cart;
import com.cg.model.CartDetail;
import com.cg.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService implements ICategoryService {

    @Autowired
    public CartRepository cartRepository;
    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }


    @Override
    public List<CartDetail> getAllCartDetail(Cart cart) {
        return cartRepository.getAllCartDetail(cart);
    }
}
