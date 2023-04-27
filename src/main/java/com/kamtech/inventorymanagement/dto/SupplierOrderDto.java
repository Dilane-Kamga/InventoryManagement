package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Supplier;
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

    private List<SupplierOrderLineDto> supplierOrderLines;
}
