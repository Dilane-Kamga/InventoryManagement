package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.CustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(CustomerDto customerDto){

        List<String> errors = new ArrayList<>();

        if(customerDto == null){
            errors.add("Customer is required");
            return errors;
        }

        if(!StringUtils.hasLength(customerDto.getFirstName())){
            errors.add("First name is required");
        }

        if(!StringUtils.hasLength(customerDto.getLastName())){
            errors.add("Last name is required");
        }

        if(!StringUtils.hasLength(customerDto.getEmail())){
            errors.add("Email is required");
        }

        if(!StringUtils.hasLength(customerDto.getPhone())){
            errors.add("Phone number is required");
        }

        if(customerDto.getAddress() == null){
            errors.add("Address is required");
        } else {
            if(!StringUtils.hasLength(customerDto.getAddress().getAddressLine1())){
                errors.add("Address 1 is required");
            }

            if(!StringUtils.hasLength(customerDto.getAddress().getCity())){
                errors.add("City is required");
            }

            if(!StringUtils.hasLength(customerDto.getAddress().getCountry())){
                errors.add("Country is required");
            }
        }

        return errors;

    }

}
