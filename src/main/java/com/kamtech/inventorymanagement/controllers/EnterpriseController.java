package com.kamtech.inventorymanagement.controllers;

import com.kamtech.inventorymanagement.controllers.api.EnterpriseApi;
import com.kamtech.inventorymanagement.dto.EnterpriseDto;
import com.kamtech.inventorymanagement.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnterpriseController implements EnterpriseApi {

    private EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService){
        this.enterpriseService = enterpriseService;
    }

    @Override
    public EnterpriseDto save(EnterpriseDto enterpriseDto) {
        return enterpriseService.save(enterpriseDto);
    }

    @Override
    public EnterpriseDto findById(Integer id) {
        return enterpriseService.findById(id);
    }

    @Override
    public List<EnterpriseDto> findAll() {
        return enterpriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        enterpriseService.delete(id);
    }
}
