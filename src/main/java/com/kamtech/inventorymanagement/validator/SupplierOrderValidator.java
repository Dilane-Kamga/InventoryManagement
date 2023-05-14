package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.SupplierOrderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderValidator {

    public static List<String> validate(SupplierOrderDto supplierOrderDto) {


        List<String> errors = new ArrayList<>();

        if (supplierOrderDto == null) {
            errors.add("Supplier Order is required");
            return errors;
        }

        if (!StringUtils.hasLength(supplierOrderDto.getOrderNumber())) {
            errors.add("The Order number is required");
        }

        if (supplierOrderDto.getOrderDate() == null) {
            errors.add("Order date is required");
        }

        if (supplierOrderDto.getSupplier() == null) {
            errors.add("Supplier is required");
        }

        return errors;
    }
}

