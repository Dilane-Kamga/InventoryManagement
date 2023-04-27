package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.CustomerOrder;
import com.kamtech.inventorymanagement.model.Item;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class CustomerOrderLineDto {

    private Integer id;
    private ItemDto item;

    private CustomerOrderDto customerOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

}
