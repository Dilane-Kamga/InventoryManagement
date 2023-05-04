package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.CustomerOrderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderValidator {

    public static List<String> validate(CustomerOrderDto customerOrderDto){

        List<String> errors = new ArrayList<>();

        if(customerOrderDto == null){
            errors.add("Customer Order is required");
            return errors;
        }

        if(!StringUtils.hasLength(customerOrderDto.getOrderNumber())){
            errors.add("The Order number is required");
        }

        if(customerOrderDto.getOrderDate() == null){
            errors.add("Order date is required");
        }

        if(customerOrderDto.getCustomer() == null){
            errors.add("Customer is required");
        }

        return errors;
    }
}
