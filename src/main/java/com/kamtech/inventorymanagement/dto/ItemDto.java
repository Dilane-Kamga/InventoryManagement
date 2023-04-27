package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Category;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class ItemDto {

    private Integer id;
    private String itemCode;

    private String designation;

    private BigDecimal unitPrice;

    private BigDecimal taxRate;

    private BigDecimal unitPriceTaxed;

    private String picture;

    private CategoryDto category;
}
