package com.nc.ecommerce.service.impl;

import com.nc.ecommerce.dto.ProductDTO;
import com.nc.ecommerce.mapper.ProductMapper;
import com.nc.ecommerce.model.Product;
import com.nc.ecommerce.repository.ProductRepository;
import com.nc.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductDTO saveProduct(ProductDTO productDTO){

        Product entity = productMapper.toEntity(productDTO);
        productRepository.save(entity);
        return productMapper.toDto(entity);
    }

    @Override
    public ProductDTO updateProduct(Long id,ProductDTO productDTO){

     Optional<Product> entity = productRepository.findById(id);
     if (entity.isEmpty()){
         return null;
     }
     productMapper.update(entity.get(),productDTO);
     productRepository.save(entity.get());
     return productMapper.toDto(entity.get());
    }

    @Override
    public ProductDTO findProductById(Long id){
        Optional<Product> entity = productRepository.findById(id);
        if (entity.isEmpty()){
            return null;
        }

        return productMapper.toDto(entity.get());
    }

    @Override
    public void deleteProduct(Long id){
        Optional<Product> entity = productRepository.findById(id);
        if (entity.isEmpty()){
          //  return null;
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getAllProducts(){
        return productMapper.toDtoList(productRepository.findAll());
    }
}
