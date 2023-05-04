package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.CustomerOrder;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CustomerOrderDto {

    private Integer id;
    private String orderNumber;

    private Instant orderDate;

    private CustomerDto customer;

    @JsonIgnore
    private List<CustomerOrderLineDto> customerOrderLines;


    public static CustomerOrderDto fromEntity(CustomerOrder customerOrder) {

        if(customerOrder == null) {
            return null;
        }

        return CustomerOrderDto.builder()
                .id(customerOrder.getId())
                .orderNumber(customerOrder.getOrderNumber())
                .orderDate(customerOrder.getOrderDate())
                .customer(CustomerDto.fromEntity(customerOrder.getCustomer()))
                .build();
    }

    public static CustomerOrder toEntity(CustomerOrderDto customerOrderDto) {

        if(customerOrderDto == null) {
            return null;
        }

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderDto.getId());
        customerOrder.setOrderNumber(customerOrderDto.getOrderNumber());
        customerOrder.setOrderDate(customerOrderDto.getOrderDate());
        customerOrder.setCustomer(CustomerDto.toEntity(customerOrderDto.getCustomer()));

        return customerOrder;
    }
}
