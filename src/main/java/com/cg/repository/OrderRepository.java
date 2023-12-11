package com.cg.repository;

import com.cg.model.dto.OrderDetailDTO;
import com.cg.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

   @Query("select new com.cg.model.dto.OrderDetailDTO (" +
               "ord.totalProduct," +
               "ord.subTotal," +
               "ord.shipping," +
               "ord.totalAmount," +
               "ord.status," +
               "ord.customerInfo" +
           ") " +
           "from Order as ord")
    List<OrderDetailDTO> getAllOrderDetailDTO();
}
