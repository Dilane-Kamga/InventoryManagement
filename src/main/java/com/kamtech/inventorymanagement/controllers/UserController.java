package com.kamtech.inventorymanagement.controllers;


import com.kamtech.inventorymanagement.controllers.api.UserApi;
import com.kamtech.inventorymanagement.dto.UserDto;
import com.kamtech.inventorymanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userService.save(userDto);
    }

    @Override
    public UserDto findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }
}
