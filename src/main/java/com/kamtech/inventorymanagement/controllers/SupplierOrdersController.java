package com.kamtech.inventorymanagement.controllers;

import com.kamtech.inventorymanagement.controllers.api.SupplierOrderApi;
import com.kamtech.inventorymanagement.dto.SupplierOrderDto;
import com.kamtech.inventorymanagement.services.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierOrdersController implements SupplierOrderApi {

    private SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrdersController(SupplierOrderService supplierOrderService){
        this.supplierOrderService = supplierOrderService;
    }


    @Override
    public SupplierOrderDto save(SupplierOrderDto supplierOrderDto) {
        return supplierOrderService.save(supplierOrderDto);
    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        return supplierOrderService.findById(id);
    }

    @Override
    public SupplierOrderDto findByCode(String orderNumber) {
        return supplierOrderService.findByCode(orderNumber);
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderService.findAll();
    }

    @Override
    public void delete(Integer id) {
        supplierOrderService.delete(id);
    }
}
