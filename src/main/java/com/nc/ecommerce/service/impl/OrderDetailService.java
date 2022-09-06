package com.nc.ecommerce.service.impl;

import com.nc.ecommerce.dto.OrderDetailDTO;
import com.nc.ecommerce.mapper.OrderDetailMapper;
import com.nc.ecommerce.model.OrderDetail;
import com.nc.ecommerce.repository.OrderDetailRepository;
import com.nc.ecommerce.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetailDTO saveOrderDetail(OrderDetailDTO dto){
        OrderDetail entity = orderDetailMapper.toEntity(dto);
        orderDetailRepository.save(entity);
        return orderDetailMapper.toDto(entity);
    }

    @Override
    public OrderDetailDTO updateOrderDetail(Long id,OrderDetailDTO dto){

        Optional<OrderDetail> entity = orderDetailRepository.findById(id);

        if (entity.isEmpty()){
            return null;
        }

        orderDetailMapper.update(entity.get(),dto);
        orderDetailRepository.save(entity.get());
        return orderDetailMapper.toDto(entity.get());
    }

    @Override
    public OrderDetailDTO findProductById(Long id){
        Optional<OrderDetail> entity = orderDetailRepository.findById(id);

        if (entity.isEmpty()){
            return null;
        }
        return orderDetailMapper.toDto(entity.get());
    }

    @Override
    public void deleteOrderDetail(Long id){

        Optional<OrderDetail> entity = orderDetailRepository.findById(id);

      /*  if (entity.isEmpty()){
            return null;
        }*/

        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetailDTO> getAllOrderDetail(){return orderDetailMapper.toDtoList(orderDetailRepository.findAll());}
}
