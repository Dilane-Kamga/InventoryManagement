package com.kamtech.inventorymanagement.services;

import com.kamtech.inventorymanagement.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto save(SupplierDto supplierDto);

    SupplierDto findById(Integer id);

    List<SupplierDto> findAll();

    void delete(Integer id);
}

