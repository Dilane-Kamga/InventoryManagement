package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.CustomerOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderLineValidator {

    public static List<String> validate(CustomerOrderLineDto customerOrderLineDto){

        List<String> errors = new ArrayList<>();

        if(customerOrderLineDto == null){
            errors.add("Customer Order Line is required");
            return errors;
        }

        if(customerOrderLineDto.getItem() == null){
            errors.add("item is required");
        }

        if(customerOrderLineDto.getCustomerOrder() == null){
            errors.add("Customer Order is required");
        }

        if(customerOrderLineDto.getQuantity() == null){
            errors.add("Quantity is required");
        }

        if(customerOrderLineDto.getUnitPrice() == null){
            errors.add("Unit price is required");
        }

        return errors;
    }
}
