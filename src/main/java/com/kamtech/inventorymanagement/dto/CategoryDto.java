package com.kamtech.inventorymanagement.dto;

import com.kamtech.inventorymanagement.model.Item;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

    private List<ItemDto> items;
}
