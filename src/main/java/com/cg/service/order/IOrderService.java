package com.cg.service.order;

import com.cg.model.dto.OrderDetailDTO;
import com.cg.model.Order;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IOrderService extends IGeneralService<Order,Long> {
    List<OrderDetailDTO> getAllOrderDetailDTO();
}
