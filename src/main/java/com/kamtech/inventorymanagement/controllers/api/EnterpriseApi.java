package com.kamtech.inventorymanagement.controllers.api;

import com.kamtech.inventorymanagement.dto.EnterpriseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/enterprises")
public interface EnterpriseApi {

    @PostMapping(APP_ROOT + "/enterprises/create")
    EnterpriseDto save(@RequestBody EnterpriseDto enterpriseDto);

    @GetMapping(APP_ROOT + "/enterprises/{enterpriseId}")
    EnterpriseDto findById(@PathVariable("enterpriseId") Integer id);

    @GetMapping(APP_ROOT + "/enterprises/all")
    List<EnterpriseDto> findAll();

    @DeleteMapping(APP_ROOT + "/enterprises/delete/{enterpriseId}")
    void delete(@PathVariable("enterpriseId") Integer id);
}
