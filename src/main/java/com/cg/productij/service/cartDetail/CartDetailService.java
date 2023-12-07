package com.cg.productij.service.cartDetail;

import com.cg.productij.model.CartDetail;
import com.cg.productij.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CartDetailService implements ICartDetailService{
    @Autowired
    public CartDetailRepository cartDetailRepository;

    @Override
    public List<CartDetail> findAll() {
        return cartDetailRepository.findAll();
    }

    @Override
    public Optional<CartDetail> findById(Long id) {
        return cartDetailRepository.findById(id);
    }

    @Override
    public void save(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public void deleteById(Long id) {
        cartDetailRepository.deleteById(id);
    }

    @Override
    public boolean existsByProduct_Id(Long idProduct) {
        return cartDetailRepository.existsByProduct_Id(idProduct);
    }

    @Override
    public CartDetail getCartDetailByProduct_Id(Long idProduct) {
        return cartDetailRepository.getCartDetailByProduct_Id(idProduct);
    }

    @Override
    public List<CartDetail> findAllByCart_Id(Long idCart) {
        return cartDetailRepository.findAllByCart_Id(idCart);
    }

    @Override
    public List<CartDetail> deleteAllByCart_Id(Long idCart) {
        return cartDetailRepository.deleteAllByCart_Id(idCart);
    }
}
