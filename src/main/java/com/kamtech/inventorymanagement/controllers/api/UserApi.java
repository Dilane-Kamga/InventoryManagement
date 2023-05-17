package com.kamtech.inventorymanagement.controllers.api;

import com.kamtech.inventorymanagement.dto.UserDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/users")
public interface UserApi {

    @PostMapping(APP_ROOT + "/users/create")
    UserDto save(@RequestBody UserDto userDto);

    @GetMapping(APP_ROOT + "/users/{userId}")
    UserDto findById(@PathVariable("userId") Integer id);

    @GetMapping(APP_ROOT + "/users/all")
    List<UserDto> findAll();

    @DeleteMapping(APP_ROOT + "/users/delete{userId}")
    void delete(@PathVariable("userId") Integer id);
}
