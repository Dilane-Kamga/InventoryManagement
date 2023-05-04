package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.CustomerOrderLineDto;
import com.kamtech.inventorymanagement.dto.SupplierOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderLineValidator {

    public static List<String> validate(SupplierOrderLineDto supplierOrderLineDto){

        List<String> errors = new ArrayList<>();

        if(supplierOrderLineDto == null){
            errors.add("Supplier Order Line is required");
            return errors;
        }

        if(supplierOrderLineDto.getItem() == null){
            errors.add("item is required");
        }

        if(supplierOrderLineDto.getSupplierOrder() == null){
            errors.add("Supplier Order is required");
        }

        if(supplierOrderLineDto.getQuantity() == null){
            errors.add("Quantity is required");
        }

        if(supplierOrderLineDto.getUnitPrice() == null){
            errors.add("Unit price is required");
        }

        return errors;
    }
}
