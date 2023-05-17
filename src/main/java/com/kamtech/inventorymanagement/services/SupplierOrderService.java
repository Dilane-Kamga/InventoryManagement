package com.kamtech.inventorymanagement.services;


import com.kamtech.inventorymanagement.dto.SupplierOrderDto;

import java.util.List;

public interface SupplierOrderService {

    SupplierOrderDto save(SupplierOrderDto supplierOrderDto);

    SupplierOrderDto findById(Integer id);

    SupplierOrderDto findByCode(String orderNumber);

    List<SupplierOrderDto> findAll();

    void delete(Integer id);
}
