package com.kamtech.inventorymanagement.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AddressDto {


    private String addressLine1;

    private String addressLine2;

    private String city;

    private String zipCode;

    private String country;

}
