package com.kamtech.inventorymanagement.services;

import com.kamtech.inventorymanagement.dto.CustomerOrderDto;

import java.util.List;

public interface CustomerOrderService {

    CustomerOrderDto save(CustomerOrderDto customerOrderDto);

    CustomerOrderDto findById(Integer id);

    CustomerOrderDto findByCode(String code);

    List<CustomerOrderDto> findAll();

    void delete(Integer id);
}
