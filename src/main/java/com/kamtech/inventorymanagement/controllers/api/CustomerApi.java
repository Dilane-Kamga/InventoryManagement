package com.kamtech.inventorymanagement.controllers.api;

import com.kamtech.inventorymanagement.dto.CustomerDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/customers")
public interface CustomerApi {

    @PostMapping(value = APP_ROOT + "/customers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto save(@RequestBody CustomerDto customerDto);

    @GetMapping(value = APP_ROOT + "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto findById(@PathVariable("customerId") Integer id);

    @GetMapping(value = APP_ROOT + "/customers/All", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/customers/delete/{customerId}")
    void delete(@PathVariable("customerId") Integer id);
}
