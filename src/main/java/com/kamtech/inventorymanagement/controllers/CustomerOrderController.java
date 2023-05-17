package com.kamtech.inventorymanagement.controllers;

import com.kamtech.inventorymanagement.controllers.api.CustomerOrderApi;
import com.kamtech.inventorymanagement.dto.CustomerOrderDto;
import com.kamtech.inventorymanagement.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerOrderController implements CustomerOrderApi {

    private CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService){
        this.customerOrderService = customerOrderService;
    }
    @Override
    public ResponseEntity<CustomerOrderDto> save(CustomerOrderDto customerOrderDto) {
        return ResponseEntity.ok(customerOrderService.save(customerOrderDto));
    }

    @Override
    public ResponseEntity<CustomerOrderDto> findById(Integer id) {
        return ResponseEntity.ok(customerOrderService.findById(id));
    }

    @Override
    public ResponseEntity<CustomerOrderDto> findByCode(String code) {
        return ResponseEntity.ok(customerOrderService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<CustomerOrderDto>> findAll() {
        return ResponseEntity.ok(customerOrderService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        customerOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
