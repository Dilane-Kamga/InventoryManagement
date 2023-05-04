package com.kamtech.inventorymanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Roles;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {

    private Integer id;
    private String roleName;

    private UserDto user;

    public static RolesDto fromEntity(Roles roles) {

        if(roles == null) {
            return null;
        }

    return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .user(UserDto.fromEntity(roles.getUser()))
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {

        if(rolesDto == null) {
            return null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
        roles.setUser(UserDto.toEntity(rolesDto.getUser()));

        return roles;
    }
}
