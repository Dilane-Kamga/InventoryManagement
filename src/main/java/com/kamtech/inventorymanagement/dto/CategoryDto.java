package com.kamtech.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Category;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

//    private Integer idEnterprise;

    @JsonIgnore
    private List<ItemDto> items;

    public static CategoryDto fromEntity(Category category) {

        if(category == null) {
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
//                .idEnterprise(category.getIdEnterprise())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {

        if(categoryDto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
//        category.setIdEnterprise(categoryDto.getIdEnterprise());

        return category;
    }
}
