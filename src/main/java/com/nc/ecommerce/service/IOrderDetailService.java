package com.nc.ecommerce.service;

import com.nc.ecommerce.dto.OrderDetailDTO;

import java.util.List;

public interface IOrderDetailService {

    public OrderDetailDTO saveOrderDetail(OrderDetailDTO dto);

    public OrderDetailDTO updateOrderDetail(Long id,OrderDetailDTO dto);

    public OrderDetailDTO findProductById(Long id);

    public void deleteOrderDetail(Long id);

    public List<OrderDetailDTO> getAllOrderDetail();
}
