package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.SupplierDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {

    public static List<String> validate(SupplierDto supplierDto){

        List<String> errors = new ArrayList<>();

        if(supplierDto == null){
            errors.add("Customer is required");
            return errors;
        }

        if(!StringUtils.hasLength(supplierDto.getFirstName())){
            errors.add("First name is required");
        }

        if(!StringUtils.hasLength(supplierDto.getLastName())){
            errors.add("Last name is required");
        }

        if(!StringUtils.hasLength(supplierDto.getEmail())){
            errors.add("Email is required");
        }

        if(!StringUtils.hasLength(supplierDto.getPhone())){
            errors.add("Phone number is required");
        }

        if(supplierDto.getAddress() == null){
            errors.add("Address is required");
        } else {
            if(!StringUtils.hasLength(supplierDto.getAddress().getAddressLine1())){
                errors.add("Address 1 is required");
            }

            if(!StringUtils.hasLength(supplierDto.getAddress().getCity())){
                errors.add("City is required");
            }

            if(!StringUtils.hasLength(supplierDto.getAddress().getCountry())){
                errors.add("Country is required");
            }
        }

        return errors;
    }
}
