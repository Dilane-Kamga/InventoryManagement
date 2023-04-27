package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.CustomerOrder;
import com.kamtech.inventorymanagement.model.CustomerOrderLine;
import com.kamtech.inventorymanagement.model.Item;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class CustomerOrderLineDto {

    private Integer id;
    @JsonIgnore
    private ItemDto item;

    @JsonIgnore
    private CustomerOrderDto customerOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;


    public CustomerOrderLineDto fromEntity(CustomerOrderLine customerOrderLine) {

        if(customerOrderLine == null) {
            return null;
        }

        return CustomerOrderLineDto.builder()
                .id(customerOrderLine.getId())
                .quantity(customerOrderLine.getQuantity())
                .unitPrice(customerOrderLine.getUnitPrice())
                .build();
    }

    public CustomerOrderLine toEntity(CustomerOrderLineDto customerOrderLineDto) {

        if(customerOrderLineDto == null) {
            return null;
        }

        CustomerOrderLine customerOrderLine = new CustomerOrderLine();
        customerOrderLine.setId(customerOrderLineDto.getId());
        customerOrderLine.setQuantity(customerOrderLineDto.getQuantity());
        customerOrderLine.setUnitPrice(customerOrderLineDto.getUnitPrice());

        return customerOrderLine;
    }

}
