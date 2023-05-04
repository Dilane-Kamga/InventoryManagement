package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Sales;
import com.kamtech.inventorymanagement.model.SalesLine;
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


    public static SalesLineDto fromEntity(SalesLine salesLine) {

        if (salesLine == null) {
            return null;
        }

        return SalesLineDto.builder()
                .id(salesLine.getId())
                .quantity(salesLine.getQuantity())
                .unitPrice(salesLine.getUnitPrice())
                .sales(SalesDto.fromEntity(salesLine.getSales()))
                .build();
    }

    public static SalesLine toEntity(SalesLineDto salesLineDto) {

        if (salesLineDto == null) {
            return null;
        }

        SalesLine salesLine = new SalesLine();
        salesLine.setId(salesLineDto.getId());
        salesLine.setQuantity(salesLineDto.getQuantity());
        salesLine.setUnitPrice(salesLineDto.getUnitPrice());
        salesLine.setSales(SalesDto.toEntity(salesLineDto.getSales()));

        return salesLine;
    }

}
