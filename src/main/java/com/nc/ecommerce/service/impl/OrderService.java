package com.nc.ecommerce.service.impl;

import com.nc.ecommerce.dto.OrderDTO;
import com.nc.ecommerce.mapper.OrderMapper;
import com.nc.ecommerce.model.Order;
import com.nc.ecommerce.repository.OrderRepository;
import com.nc.ecommerce.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO saveOrder(OrderDTO dto){
        Order entity = orderMapper.toEntity(dto);
        orderRepository.save(entity);
        return orderMapper.toDto(entity);
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO dto){

        Optional<Order> entity = orderRepository.findById(id);

        if (entity.isEmpty()){
            return null;
        }

        orderMapper.update(entity.get(), dto);
        orderRepository.save(entity.get());
        return orderMapper.toDto(entity.get());
    }

    @Override
    public OrderDTO findProductById(Long id) {
        Optional<Order> entity = orderRepository.findById(id);
        if (entity.isEmpty()){
            return null;
        }
        return orderMapper.toDto(entity.get());
    }

    @Override
    public void deleteOrder(Long id){

        Optional<Order> entity = orderRepository.findById(id);

        if (entity.isEmpty()){
         //   return null;
        }

        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getAllOrders(){return orderMapper.toDtoList(orderRepository.findAll());}


}
