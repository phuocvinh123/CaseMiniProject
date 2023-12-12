package com.cg.service.order;

import com.cg.model.dto.reponse.OrderDTO;
import com.cg.model.Order;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IOrderService extends IGeneralService<Order,Long> {
    List<OrderDTO> getAllOrderDetailDTO();
}
