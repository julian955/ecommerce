package com.nc.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class OrderDTO {

    private Long id;
    private String number;
    private LocalDate recived;
    private Double total;
    private Long userId;
    private Long orderDetailId;
}
