package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.SalesLineDto;

import java.util.ArrayList;
import java.util.List;

public class SalesLineValidator {

    public List<String> validate(SalesLineDto salesLineDto){

        List<String> errors = new ArrayList<>();

        if(salesLineDto == null){
            errors.add("Sales Line is required");
            return errors;
        }

        if(salesLineDto.getSales() == null){
            errors.add("Sales is required");
        }

        if(salesLineDto.getQuantity() == null){
            errors.add("Quantity is required");
        }

        if(salesLineDto.getUnitPrice() == null){
            errors.add("Unit Price is required");
        }

        return errors;
    }
}
