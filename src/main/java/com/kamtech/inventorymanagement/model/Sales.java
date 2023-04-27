package com.kamtech.inventorymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sales")
public class Sales extends AbstractEntity{

    @Column(name = "customer_id")
    private String salesCode;
    @Column(name = "sales_date")
    private Instant salesDate;
    @Column(name = "comment")
    private String comment;
}
