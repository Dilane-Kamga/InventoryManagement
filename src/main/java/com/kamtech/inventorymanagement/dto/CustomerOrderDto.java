package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Customer;
import com.kamtech.inventorymanagement.model.CustomerOrder;
import com.kamtech.inventorymanagement.model.CustomerOrderLine;
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

    @JsonIgnore
    private CustomerDto customer;

    @JsonIgnore
    private List<CustomerOrderLineDto> customerOrderLines;


    public CustomerOrderDto fromEntity(CustomerOrder customerOrder) {

        if(customerOrder == null) {
            return null;
        }

        return CustomerOrderDto.builder()
                .id(customerOrder.getId())
                .orderNumber(customerOrder.getOrderNumber())
                .orderDate(customerOrder.getOrderDate())
                .build();
    }

    public CustomerOrder toEntity(CustomerOrderDto customerOrderDto) {

        if(customerOrderDto == null) {
            return null;
        }

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderDto.getId());
        customerOrder.setOrderNumber(customerOrderDto.getOrderNumber());
        customerOrder.setOrderDate(customerOrderDto.getOrderDate());

        return customerOrder;
    }
}
