package com.nc.ecommerce.mapper;

import com.nc.ecommerce.dto.OrderDetailDTO;
import com.nc.ecommerce.model.OrderDetail;
import com.nc.ecommerce.repository.OrderDetailRepository;
import com.nc.ecommerce.repository.OrderRepository;
import com.nc.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.nc.ecommerce.util.MapperUtil.streamListNonNull;

@Component
public class OrderDetailMapper implements IMapper<OrderDetail, OrderDetailDTO>{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderDetail toEntity(OrderDetailDTO dto) {
        return OrderDetail.builder()
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .total(dto.getTotal())
                .order(orderRepository.getReferenceById(dto.getOrderId()))
                .product(productRepository.getReferenceById(dto.getProductId()))
                .build();
    }

    @Override
    public OrderDetail toEntity(Long id, OrderDetailDTO dto) {
        return OrderDetail.builder()
                .id(id)
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .total(dto.getTotal())
                .order(orderRepository.getReferenceById(dto.getOrderId()))
                .product(productRepository.getReferenceById(dto.getProductId()))
                .build();
    }

    @Override
    public OrderDetailDTO toDto(OrderDetail entity) {
        return OrderDetailDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .total(entity.getTotal())
                .orderId(entity.getOrder().getId())
                .productId(entity.getProduct().getId())
                .build();
    }

    @Override
    public List<OrderDetailDTO> toDtoList(List<OrderDetail> list) {
        return streamListNonNull(list, this::toDto);
    }

    public void update(OrderDetail model, OrderDetailDTO dto){
        model.setName(dto.getName());
        model.setQuantity(dto.getQuantity());
        model.setPrice(dto.getPrice());
        model.setTotal(dto.getTotal());
        if (!Objects.equals(model.getOrder().getId(), dto.getOrderId())){
            model.setOrder(orderRepository.getReferenceById(dto.getOrderId()));
        }
        if (!Objects.equals(model.getProduct().getId(), dto.getProductId())){
            model.setProduct(productRepository.getReferenceById(dto.getProductId()));
        }
    }
}
