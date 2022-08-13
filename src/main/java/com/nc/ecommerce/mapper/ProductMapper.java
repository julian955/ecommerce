package com.nc.ecommerce.mapper;

import com.nc.ecommerce.dto.ProductDTO;
import com.nc.ecommerce.model.Product;
import com.nc.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.nc.ecommerce.util.MapperUtil.streamListNonNull;

import java.util.List;

public class ProductMapper implements IMapper<Product,ProductDTO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Product toEntity(ProductDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }

    @Override
    public Product toEntity(Long id, ProductDTO dto) {
        return Product.builder()
                .id(id)
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }

    @Override
    public ProductDTO toDto(Product entity) {
        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .image(entity.getImage())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .userId(entity.getUser().getId())
                .build();
    }

    @Override
    public List<ProductDTO> toDtoList(List<Product> list) {
       return streamListNonNull(list, this::toDto);
    }

    public void update(Product model,ProductDTO dto){
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setImage(dto.getImage());
        model.setPrice(dto.getPrice());
        model.setQuantity(dto.getQuantity());
        if (model.getUser().getId() != dto.getUserId()){
            model.setUser(userRepository.getReferenceById(dto.getUserId()));
        }
    }
}
