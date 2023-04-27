package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Item;
import com.kamtech.inventorymanagement.model.SupplierOrder;
import com.kamtech.inventorymanagement.model.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class SupplierOrderLineDto {

    private Integer id;
    @JsonIgnore
    private ItemDto item;
    @JsonIgnore
    private SupplierOrderDto supplierOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public SupplierOrderLineDto fromEntity(SupplierOrderLine supplierOrderLine){

        if(supplierOrderLine == null){
            return null;
        }

        return SupplierOrderLineDto.builder()
                .id(supplierOrderLine.getId())
                .quantity(supplierOrderLine.getQuantity())
                .unitPrice(supplierOrderLine.getUnitPrice())
                .item(ItemDto.builder().id(supplierOrderLine.getItem().getId()).build())
                .supplierOrder(SupplierOrderDto.builder().id(supplierOrderLine.getSupplierOrder().getId()).build())
                .build();
    }

    public SupplierOrderLine toEntity(SupplierOrderLineDto supplierOrderLineDto){

        if(supplierOrderLineDto == null){
            return null;
        }

        SupplierOrderLine supplierOrderLine = new SupplierOrderLine();
        supplierOrderLine.setId(supplierOrderLineDto.getId());
        supplierOrderLine.setQuantity(supplierOrderLineDto.getQuantity());
        supplierOrderLine.setUnitPrice(supplierOrderLineDto.getUnitPrice());

        return supplierOrderLine;
    }

}
