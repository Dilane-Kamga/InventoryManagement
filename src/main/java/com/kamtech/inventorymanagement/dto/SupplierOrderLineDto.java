package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Item;
import com.kamtech.inventorymanagement.model.SupplierOrder;
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

}
