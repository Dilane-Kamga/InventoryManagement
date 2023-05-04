package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Supplier;
import com.kamtech.inventorymanagement.model.SupplierOrder;
import com.kamtech.inventorymanagement.model.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SupplierOrderDto {

    private Integer id;

    private String orderNumber;

    private Instant orderDate;

    private SupplierDto supplier;
    @JsonIgnore
    private List<SupplierOrderLineDto> supplierOrderLines;

    public static SupplierOrderDto fromEntity(SupplierOrder supplierOrder){

        if(supplierOrder == null){
            return null;
        }

        return SupplierOrderDto.builder()
                .id(supplierOrder.getId())
                .orderNumber(supplierOrder.getOrderNumber())
                .orderDate(supplierOrder.getOrderDate())
                .build();
    }

    public static SupplierOrder toEntity(SupplierOrderDto supplierOrderDto){

        if(supplierOrderDto == null){
            return null;
        }

        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setId(supplierOrderDto.getId());
        supplierOrder.setOrderNumber(supplierOrderDto.getOrderNumber());
        supplierOrder.setOrderDate(supplierOrderDto.getOrderDate());

        return supplierOrder;
    }
}
