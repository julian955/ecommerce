package com.nc.ecommerce.controller;

import com.nc.ecommerce.dto.ProductDTO;
import com.nc.ecommerce.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService service;


    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(ProductDTO dto){
        ProductDTO response = service.saveProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> editProduct(Long id,ProductDTO dto){
        return ResponseEntity.ok(service.updateProduct(id,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(Long id){
        return ResponseEntity.ok(service.findProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(Long id){
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllProducts());
    }

}
