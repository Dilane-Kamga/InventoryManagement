package com.kamtech.inventorymanagement.controllers.api;


import com.kamtech.inventorymanagement.dto.SalesDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/sales")
public interface SalesApi {

    @PostMapping(APP_ROOT + "/sales/create")
    SalesDto save(@RequestBody SalesDto salesDto);

    @GetMapping(APP_ROOT + "/sales/{salesId}")
    SalesDto findById(@PathVariable("salesId") Integer id);

    @GetMapping(APP_ROOT + "/sales/{salesCode}")
    SalesDto findByCode(@PathVariable("salesCode") String code);

    @GetMapping(APP_ROOT + "/sales/all")
    List<SalesDto> findAll();

    @DeleteMapping(APP_ROOT + "/sales/delete/{salesId}")
    void delete(@PathVariable("salesId") Integer id);
}
