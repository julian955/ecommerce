package com.nc.ecommerce.dto;

import com.nc.ecommerce.auth.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

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
