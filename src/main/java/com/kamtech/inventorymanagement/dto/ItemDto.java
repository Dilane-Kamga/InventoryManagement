package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Item;
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

    @JsonIgnore
    private CategoryDto category;

    public ItemDto fromEntity( Item item) {

        if(item == null) {
            return null;
        }

        return ItemDto.builder()
                .id(item.getId())
                .itemCode(item.getItemCode())
                .designation(item.getDesignation())
                .unitPrice(item.getUnitPrice())
                .taxRate(item.getTaxRate())
                .unitPriceTaxed(item.getUnitPriceTaxed())
                .picture(item.getPicture())
                .build();
    }

    public Item toEntity(ItemDto itemDto) {

        if(itemDto == null) {
            return null;
        }

        Item item = new Item();
        item.setId(itemDto.getId());
        item.setItemCode(itemDto.getItemCode());
        item.setDesignation(itemDto.getDesignation());
        item.setUnitPrice(itemDto.getUnitPrice());
        item.setTaxRate(itemDto.getTaxRate());
        item.setUnitPriceTaxed(itemDto.getUnitPriceTaxed());
        item.setPicture(itemDto.getPicture());

        return item;
    }
}
