package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.StkMvtDto;

import java.util.ArrayList;
import java.util.List;

public class StkMvtValidator {

    public List<String> validate(StkMvtDto stkMvtDto){

        List<String> errors = new ArrayList<>();

        if(stkMvtDto == null){
            errors.add("Stock Movement is required");
            return errors;
        }

        if(stkMvtDto.getMvtDate() == null){
            errors.add("Movement Date is required");
        }

        if(stkMvtDto.getQuantity() == null){
            errors.add("Stock Movement Quantity is required");
        }

        if(stkMvtDto.getMvtType() == null){
            errors.add("Stock Movement Type is required");
        }

        if(stkMvtDto.getItem() == null){
            errors.add("Stock Movement item is required");
        }

        return errors;
    }
}
