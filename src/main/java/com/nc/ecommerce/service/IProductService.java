package com.nc.ecommerce.service;

import com.nc.ecommerce.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO saveProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long id,ProductDTO productDTO);

    ProductDTO findProductById(Long id);

    void deleteProduct(Long id);

    List<ProductDTO> getAllProducts();
}
