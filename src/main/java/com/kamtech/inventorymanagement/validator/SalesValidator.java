package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.SalesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SalesValidator {

    public List<String> validate(SalesDto salesDto){

        List<String> errors = new ArrayList<>();

        if(salesDto == null){
            errors.add("Sales is required");
            return errors;
        }

        if(!StringUtils.hasLength(salesDto.getSalesCode())){
            errors.add("Sales code is required");
        }

        if(salesDto.getSalesDate() == null){
            errors.add("Sales date is required");
        }

        return errors;

    }
}
