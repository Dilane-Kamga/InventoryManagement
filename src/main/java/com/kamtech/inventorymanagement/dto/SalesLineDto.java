package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Sales;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class SalesLineDto {

    private Integer id;

    private SalesDto sales;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
