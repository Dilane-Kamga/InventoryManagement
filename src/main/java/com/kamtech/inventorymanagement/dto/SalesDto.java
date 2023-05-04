package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Sales;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;

@Data
@Builder
public class SalesDto {

    private Integer id;
    private String salesCode;

    private Instant salesDate;

    private String comment;

    public static SalesDto fromEntity(Sales sales) {

        if (sales == null) {
            return null;
        }

        return SalesDto.builder()
                .id(sales.getId())
                .salesCode(sales.getSalesCode())
                .salesDate(sales.getSalesDate())
                .comment(sales.getComment())
                .build();
    }

    public static Sales toEntity(SalesDto salesDto) {

        if (salesDto == null) {
            return null;
        }

        Sales sales = new Sales();
        sales.setId(salesDto.getId());
        sales.setSalesCode(salesDto.getSalesCode());
        sales.setSalesDate(salesDto.getSalesDate());
        sales.setComment(salesDto.getComment());

        return sales;
    }


}
