package com.cg.repository;

import com.cg.model.dto.reponse.OrderDTO;
import com.cg.model.Order;
import com.cg.model.dto.reponse.OrderDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("select new com.cg.model.dto.reponse.OrderDTO (" +
            "ord.totalProduct," +
            "ord.subTotal," +
            "ord.shipping," +
            "ord.totalAmount," +
            "ord.status," +
            "ord.customerInfo" +
            ") " +
            "from Order as ord")
    List<OrderDTO> getAllOrderDetailDTO();

}
