package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.ItemDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {

    public static List<String> validate(ItemDto itemDto){

        List<String> errors = new ArrayList<>();

        if(itemDto == null){
            errors.add("Item is required");
            return errors;
        }


        if(!StringUtils.hasLength(itemDto.getItemCode())){
            errors.add("item code is required");
        }

        if(!StringUtils.hasLength(itemDto.getDesignation())){
            errors.add("Designation is required");
        }

        if(itemDto.getUnitPrice() == null){
            errors.add("unit price is required");
        }

        if(itemDto.getTaxRate() == null){
            errors.add("Tax rate is required");
        }

        if(itemDto.getUnitPriceTaxed() == null){
            errors.add("Taxed Unit Price is required");
        }

        if(itemDto.getCategory() == null){
            errors.add("Category is required");
        }

        return errors;
    }

}
