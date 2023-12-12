package com.cg.service.orderDetail;

import com.cg.model.OrderDetail;
import com.cg.model.dto.reponse.OrderDetailDTO;
import com.cg.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteById(Long id) {
        orderDetailRepository.deleteById(id);
    }


//    @Override
//    public List<OrderDetailDTO> getAllOrderDetail() {
//        return orderDetailRepository.getAllOrderDetail();
//    }
}
