package com.kamtech.inventorymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sales_line")
public class SalesLine extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
    @Column(name = "quantity")
    private BigDecimal quantity;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
}