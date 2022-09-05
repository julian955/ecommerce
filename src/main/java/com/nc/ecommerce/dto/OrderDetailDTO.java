package com.nc.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetailDTO {

    private Long id;
    private String name;
    private Double quantity;
    private Double price;
    private Double total;
    private Long orderId;
    private Long productId;
}
