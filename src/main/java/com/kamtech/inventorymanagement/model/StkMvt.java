package com.kamtech.inventorymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stk_mvt")
public class StkMvt extends AbstractEntity{

        @Column(name = "mvt_date")
        private Instant mvtDate;
        @Column(name = "quantity")
        private BigDecimal quantity;
        @Column(name = "mvt_type")
        private MvtType mvtType;
        @ManyToOne
        @JoinColumn(name = "item_id")
        private Item item;
}
