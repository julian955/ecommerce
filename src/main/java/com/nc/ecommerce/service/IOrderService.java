package com.nc.ecommerce.service;

import com.nc.ecommerce.dto.OrderDTO;

import java.util.List;

public interface IOrderService {

    public OrderDTO saveOrder(OrderDTO dto);

    public OrderDTO updateOrder(Long id, OrderDTO dto);

    public OrderDTO findProductById(Long id);

    public void deleteOrder(Long id);

    public List<OrderDTO> getAllOrders();
}
