package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Address;
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

    private AddressDto address;

    private List<SupplierOrderDto> supplierOrders;
}
