package com.kamtech.inventorymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="supplier_order")
public class SupplierOrder extends AbstractEntity{

    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "order_date")
    private Instant orderDate;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @OneToMany(mappedBy = "supplierOrder")
    private List<SupplierOrderLine> supplierOrderLines;
}
