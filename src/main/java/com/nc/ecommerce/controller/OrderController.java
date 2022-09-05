package com.nc.ecommerce.controller;

import com.nc.ecommerce.dto.OrderDTO;
import com.nc.ecommerce.dto.ProductDTO;
import com.nc.ecommerce.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> saveProduct(OrderDTO dto){
        OrderDTO response = service.saveOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> editProduct(Long id,OrderDTO dto){
        return ResponseEntity.ok(service.updateOrder(id,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getProduct(Long id){
        return ResponseEntity.ok(service.findProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(Long id){
        service.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllOrders());
    }
}
