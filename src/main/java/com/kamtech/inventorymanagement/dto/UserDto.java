package com.kamtech.inventorymanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.User;
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
    @JsonIgnore
    private AddressDto address;

    private String picture;
    @JsonIgnore
    private EnterpriseDto enterprise;
    @JsonIgnore
    private List<RolesDto> roles;

    public UserDto fromEntity(User user){

        if(user == null){
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .password(user.getPassword())
                .picture(user.getPicture())
                .build();
    }

    public User toEntity(UserDto userDto){

        if(userDto == null){
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPicture(userDto.getPicture());

        return user;
    }
}
