package com.kamtech.inventorymanagement.services;

import com.kamtech.inventorymanagement.dto.EnterpriseDto;

import java.util.List;

public interface EnterpriseService {

    EnterpriseDto save(EnterpriseDto enterpriseDto);

    EnterpriseDto findById(Integer id);

    List<EnterpriseDto> findAll();

    void delete(Integer id);
}
