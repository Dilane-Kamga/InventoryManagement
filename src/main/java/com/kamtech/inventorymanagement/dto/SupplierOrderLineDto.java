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

    private ItemDto item;

    private SupplierOrderDto supplierOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public static SupplierOrderLineDto fromEntity(SupplierOrderLine supplierOrderLine){

        if(supplierOrderLine == null){
            return null;
        }

        return SupplierOrderLineDto.builder()
                .id(supplierOrderLine.getId())
                .quantity(supplierOrderLine.getQuantity())
                .unitPrice(supplierOrderLine.getUnitPrice())
                .item(ItemDto.fromEntity(supplierOrderLine.getItem()))
                .supplierOrder(SupplierOrderDto.fromEntity(supplierOrderLine.getSupplierOrder()))
                .build();
    }

    public static SupplierOrderLine toEntity(SupplierOrderLineDto supplierOrderLineDto){

        if(supplierOrderLineDto == null){
            return null;
        }

        SupplierOrderLine supplierOrderLine = new SupplierOrderLine();
        supplierOrderLine.setId(supplierOrderLineDto.getId());
        supplierOrderLine.setQuantity(supplierOrderLineDto.getQuantity());
        supplierOrderLine.setUnitPrice(supplierOrderLineDto.getUnitPrice());
        supplierOrderLine.setItem(ItemDto.toEntity(supplierOrderLineDto.getItem()));
        supplierOrderLine.setSupplierOrder(SupplierOrderDto.toEntity(supplierOrderLineDto.getSupplierOrder()));

        return supplierOrderLine;
    }

}
