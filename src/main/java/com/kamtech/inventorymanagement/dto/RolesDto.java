package com.kamtech.inventorymanagement.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {

    private Integer id;
    private String roleName;

    private UserDto user;
}
