package com.kamtech.inventorymanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Customer;
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

    @JsonIgnore
    private AddressDto address;

    @JsonIgnore
    private List<CustomerOrder> customerOrders;

    public CustomerDto fromEntity(Customer customer) {

        if(customer == null) {
            return null;
        }

        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .picture(customer.getPicture())
                .build();
    }

    public Customer toEntity(CustomerDto customerDto) {

        if(customerDto == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setPicture(customerDto.getPicture());

        return customer;
    }


}
