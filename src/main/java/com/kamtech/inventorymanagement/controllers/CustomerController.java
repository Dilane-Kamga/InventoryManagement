package com.kamtech.inventorymanagement.controllers;

import com.kamtech.inventorymanagement.controllers.api.CustomerApi;
import com.kamtech.inventorymanagement.dto.CustomerDto;
import com.kamtech.inventorymanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomerApi {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerService.save(customerDto);
    }
    @Override
    public CustomerDto findById(Integer id) {
        return customerService.findById(id);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    @Override
    public void delete(Integer id) {
        customerService.delete(id);
    }
}
