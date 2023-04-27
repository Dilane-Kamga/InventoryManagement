package com.kamtech.inventorymanagement.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="item")
public class Item extends AbstractEntity{

    @Column(name = "item_code")
    private String itemCode;
    @Column(name = "designation")
    private String designation;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "tax_rate")
    private BigDecimal taxRate;
    @Column(name = "unit_price_taxed")
    private BigDecimal unitPriceTaxed;
    @Column(name = "picture")
    private String picture;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
