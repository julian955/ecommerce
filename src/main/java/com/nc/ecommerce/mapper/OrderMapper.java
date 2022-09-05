package com.nc.ecommerce.mapper;

import com.nc.ecommerce.dto.OrderDTO;
import com.nc.ecommerce.model.Order;
import com.nc.ecommerce.repository.OrderDetailRepository;
import com.nc.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.nc.ecommerce.util.MapperUtil.streamListNonNull;

public class OrderMapper implements IMapper<Order, OrderDTO>{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public Order toEntity(OrderDTO dto) {
        return Order.builder()
                .number(dto.getNumber())
                .recived(dto.getRecived())
                .total(dto.getTotal())
                .user(userRepository.getReferenceById(dto.getUserId()))
                .orderDetail(orderDetailRepository.getReferenceById(dto.getOrderDetailId()))
                .build();
    }

    @Override
    public Order toEntity(Long id, OrderDTO dto) {
        return Order.builder()
                .id(id)
                .number(dto.getNumber())
                .recived(dto.getRecived())
                .total(dto.getTotal())
                .user(userRepository.getReferenceById(dto.getUserId()))
                .orderDetail(orderDetailRepository.getReferenceById(dto.getOrderDetailId()))
                .build();
    }

    @Override
    public OrderDTO toDto(Order entity) {
        return OrderDTO.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .recived(entity.getRecived())
                .total(entity.getTotal())
                .userId(entity.getUser().getId())
                .orderDetailId(entity.getOrderDetail().getId())
                .build();
    }

    @Override
    public List<OrderDTO> toDtoList(List<Order> list) {
        return streamListNonNull(list, this::toDto);
    }


    public void update(Order entity, OrderDTO dto){
        entity.setNumber(dto.getNumber());
        entity.setRecived(dto.getRecived());
        entity.setTotal(dto.getTotal());
        entity.setOrderDetail(orderDetailRepository.getReferenceById(dto.getOrderDetailId()));
    }
}
