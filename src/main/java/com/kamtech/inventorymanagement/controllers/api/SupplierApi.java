package com.kamtech.inventorymanagement.controllers.api;


import com.kamtech.inventorymanagement.dto.SupplierDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/suppliers")
public interface SupplierApi {

    @PostMapping(APP_ROOT + "/suppliers/create")
    SupplierDto save(@RequestBody SupplierDto supplierDto);

    @GetMapping(APP_ROOT + "/suppliers/{supplierId}")
    SupplierDto findById(@PathVariable("supplierId") Integer id);

    @GetMapping(APP_ROOT + "/suppliers/all")
    List<SupplierDto> findAll();

    @DeleteMapping(APP_ROOT + "/suppliers/delete/{supplierId}")
    void delete(@PathVariable("supplierId") Integer id);
}
