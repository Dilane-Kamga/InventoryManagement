package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto) {

        List<String> errors = new ArrayList<>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Category code is required");
        }

        return errors;
    }
}
