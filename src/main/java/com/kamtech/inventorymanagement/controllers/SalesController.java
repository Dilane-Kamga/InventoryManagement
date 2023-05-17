package com.kamtech.inventorymanagement.controllers;


import com.kamtech.inventorymanagement.controllers.api.SalesApi;
import com.kamtech.inventorymanagement.dto.SalesDto;
import com.kamtech.inventorymanagement.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesController implements SalesApi {

    private SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService){
        this.salesService = salesService;
    }

    @Override
    public SalesDto save(SalesDto salesDto) {
        return salesService.save(salesDto);
    }

    @Override
    public SalesDto findById(Integer id) {
        return salesService.findById(id);
    }

    @Override
    public SalesDto findByCode(String code) {
        return salesService.findByCode(code);
    }

    @Override
    public List<SalesDto> findAll() {
        return salesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        salesService.delete(id);
    }
}
