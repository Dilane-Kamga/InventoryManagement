package com.kamtech.inventorymanagement.dto;


import com.kamtech.inventorymanagement.model.CustomerOrder;
import lombok.Builder;
import lombok.Data;


import javax.persistence.Embedded;
import java.util.List;

@Data
@Builder
public class CustomerDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String picture;

    private AddressDto address;

    private List<CustomerOrder> customerOrders;
}
