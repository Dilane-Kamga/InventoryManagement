package com.kamtech.inventorymanagement.controllers.api;


import com.kamtech.inventorymanagement.dto.SupplierOrderDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/supplierorders")
public interface SupplierOrderApi {

    @PostMapping(APP_ROOT + "/supplierorders/create")
    SupplierOrderDto save(@RequestBody SupplierOrderDto supplierOrderDto);

    @GetMapping(APP_ROOT + "/supplierorders/{supplierOrdersId}")
    SupplierOrderDto findById(@PathVariable("supplierOrdersId") Integer id);

    @GetMapping(APP_ROOT + "/supplierorders/{supplierOrdersCode}")
    SupplierOrderDto findByCode(@PathVariable("supplierOrdersCode") String orderNumber);

    @GetMapping(APP_ROOT + "/supplierorders/all")
    List<SupplierOrderDto> findAll();

    @DeleteMapping(APP_ROOT + "/supplierorders/delete/{supplierOrdersId}")
    void delete(@PathVariable("supplierOrdersId") Integer id);
}
