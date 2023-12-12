package com.cg.repository;

import com.cg.model.OrderDetail;
import com.cg.model.dto.reponse.OrderDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
//    @Query("select new com.cg.model.dto.reponse.OrderDetailDTO (" +
//            "od.order," +
//            "od.product," +
//            "od.quantity," +
//            "od.amount" +
//            ")" +
//            " from OrderDetail as od")
//    List<OrderDetailDTO> getAllOrderDetail();
}
