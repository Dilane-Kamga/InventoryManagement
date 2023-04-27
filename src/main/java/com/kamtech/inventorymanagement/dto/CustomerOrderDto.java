package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Customer;
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

    private CustomerDto customer;

    private List<CustomerOrderLineDto> customerOrderLines;
}
