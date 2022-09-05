package com.nc.ecommerce.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private String image;
    private double price;
    private int quantity;
    private Long userId;
}
