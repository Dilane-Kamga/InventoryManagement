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
    @JsonIgnore
    private UserDto user;

    public RolesDto fromEntity(Roles roles) {

        if(roles == null) {
            return null;
        }

    return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public Roles toEntity(RolesDto rolesDto) {

        if(rolesDto == null) {
            return null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());

        return roles;
    }
}
