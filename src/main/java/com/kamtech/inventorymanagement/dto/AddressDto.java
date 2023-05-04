package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Address;
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


    public static AddressDto fromEntity(Address address) {

        if(address == null) {
            return null;
        }

        return AddressDto.builder()
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .zipCode(address.getZipCode())
                .country(address.getCountry())
                .build();
    }

    public static Address toEntity(AddressDto addressDto) {

        if(addressDto == null) {
            return null;
        }

        Address address = new Address();
        address.setAddressLine1(addressDto.getAddressLine1());
        address.setAddressLine2(addressDto.getAddressLine2());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        address.setCountry(addressDto.getCountry());

        return address;
    }

}
