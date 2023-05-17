package com.kamtech.inventorymanagement.controllers.api;


import com.kamtech.inventorymanagement.dto.CustomerOrderDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/customerorders")
public interface CustomerOrderApi {

    @PostMapping(APP_ROOT + "/customerorders/create")
    ResponseEntity<CustomerOrderDto> save(@RequestBody CustomerOrderDto customerOrderDto);

    @GetMapping(APP_ROOT + "/customerorders/{customerOrdersId}")
    ResponseEntity<CustomerOrderDto> findById(@PathVariable("customerOrdersId") Integer id);

    @GetMapping(APP_ROOT + "/customerorders/{customerOrdersCode}")
    ResponseEntity<CustomerOrderDto> findByCode(@PathVariable("customerOrdersCode") String code);

    @GetMapping(APP_ROOT + "/customerorders/all")
    ResponseEntity<List<CustomerOrderDto>> findAll();

    @DeleteMapping(APP_ROOT + "/customerorders/delete/{customerOrdersId}")
    ResponseEntity delete(@PathVariable("customerOrdersId") Integer id);
}
