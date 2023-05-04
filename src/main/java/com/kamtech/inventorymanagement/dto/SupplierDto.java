package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Address;
import com.kamtech.inventorymanagement.model.Supplier;
import com.kamtech.inventorymanagement.model.SupplierOrder;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class SupplierDto {

    private Integer id;
    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String picture;
    @JsonIgnore
    private AddressDto address;
    @JsonIgnore
    private List<SupplierOrderDto> supplierOrders;

    public static SupplierDto fromEntity(Supplier supplier){

        if(supplier == null){
            return null;
        }

        return SupplierDto.builder()
                .id(supplier.getId())
                .firstName(supplier.getFirstName())
                .lastName(supplier.getLastName())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .picture(supplier.getPicture())
                .address(AddressDto.fromEntity(supplier.getAddress()))
                .build();
    }

    public static Supplier toEntity(SupplierDto supplierDto){

        if(supplierDto == null){
            return null;
        }

        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setFirstName(supplierDto.getFirstName());
        supplier.setLastName(supplierDto.getLastName());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setPhone(supplierDto.getPhone());
        supplier.setPicture(supplierDto.getPicture());
        supplier.setAddress(AddressDto.toEntity(supplierDto.getAddress()));

        return supplier;
    }
}
