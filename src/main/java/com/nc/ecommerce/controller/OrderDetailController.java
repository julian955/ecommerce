package com.nc.ecommerce.controller;

import com.nc.ecommerce.dto.OrderDTO;
import com.nc.ecommerce.dto.OrderDetailDTO;
import com.nc.ecommerce.service.IOrderDetailService;
import com.nc.ecommerce.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {

    private final IOrderDetailService service;

    @PostMapping
    public ResponseEntity<OrderDetailDTO> saveProduct(OrderDetailDTO dto){
        OrderDetailDTO response = service.saveOrderDetail(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> editProduct(Long id,OrderDetailDTO dto){
        return ResponseEntity.ok(service.updateOrderDetail(id,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> getProduct(Long id){
        return ResponseEntity.ok(service.findProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(Long id){
        service.deleteOrderDetail(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllOrderDetail());
    }
}
