package com.kamtech.inventorymanagement.dto;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UserDto {

    private Integer id;
    private String firstName;

    private String lastName;

    private Instant birthDate;

    private String email;

    private String password;

    private AddressDto address;

    private String picture;

    private EnterpriseDto enterprise;

    private List<RolesDto> roles;
}
