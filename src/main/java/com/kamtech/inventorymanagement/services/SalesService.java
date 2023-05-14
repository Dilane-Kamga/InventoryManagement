package com.kamtech.inventorymanagement.services;

import com.kamtech.inventorymanagement.dto.SalesDto;

import java.util.List;

public interface SalesService {

    SalesDto save(SalesDto salesDto);

    SalesDto findById(Integer id);

    SalesDto findByCode(String code);

    List<SalesDto> findAll();

    void delete(Integer id);

}
