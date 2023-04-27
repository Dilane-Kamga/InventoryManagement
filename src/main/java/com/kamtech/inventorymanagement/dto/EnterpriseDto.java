package com.kamtech.inventorymanagement.dto;


import lombok.Builder;
import lombok.Data;


import javax.persistence.Embedded;
import java.util.List;

@Data
@Builder
public class EnterpriseDto {

    private Integer id;

    private String name;

    private String description;

    private String taxId;

    private AddressDto address;

    private String phone;

    private String email;

    private String website;

    private String picture;

    private List<UserDto> users;
}
