package com.kamtech.inventorymanagement.dto;


import com.kamtech.inventorymanagement.model.CustomerOrderLine;
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


    public static CustomerOrderLineDto fromEntity(CustomerOrderLine customerOrderLine) {

        if(customerOrderLine == null) {
            return null;
        }

        return CustomerOrderLineDto.builder()
                .id(customerOrderLine.getId())
                .quantity(customerOrderLine.getQuantity())
                .unitPrice(customerOrderLine.getUnitPrice())
                .customerOrder(CustomerOrderDto.fromEntity(customerOrderLine.getCustomerOrder()))
                .item(ItemDto.fromEntity(customerOrderLine.getItem()))
                .build();
    }

    public static CustomerOrderLine toEntity(CustomerOrderLineDto customerOrderLineDto) {

        if(customerOrderLineDto == null) {
            return null;
        }

        CustomerOrderLine customerOrderLine = new CustomerOrderLine();
        customerOrderLine.setId(customerOrderLineDto.getId());
        customerOrderLine.setQuantity(customerOrderLineDto.getQuantity());
        customerOrderLine.setUnitPrice(customerOrderLineDto.getUnitPrice());
        customerOrderLine.setCustomerOrder(CustomerOrderDto.toEntity(customerOrderLineDto.getCustomerOrder()));
        customerOrderLine.setItem(ItemDto.toEntity(customerOrderLineDto.getItem()));

        return customerOrderLine;
    }

}
