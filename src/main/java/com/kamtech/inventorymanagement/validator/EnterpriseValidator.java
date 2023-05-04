package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.EnterpriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseValidator {

    public static List<String> validate(EnterpriseDto enterpriseDto){

        List<String> errors = new ArrayList<>();

        if(enterpriseDto == null){
            errors.add("Enterprise is required");
            return errors;
        }

        if(!StringUtils.hasLength(enterpriseDto.getName())){
            errors.add("Name is required");
        }

        if(!StringUtils.hasLength(enterpriseDto.getDescription())){
            errors.add("Description is required");
        }

        if(!StringUtils.hasLength(enterpriseDto.getTaxId())){
            errors.add("Tax Id is required");
        }

        if(!StringUtils.hasLength(enterpriseDto.getPhone())){
            errors.add("Phone number is required");
        }

        if(!StringUtils.hasLength(enterpriseDto.getEmail())){
            errors.add("Email is required");
        }

        if(enterpriseDto.getAddress() == null){
            errors.add("Address is required");
        } else {
            if(!StringUtils.hasLength(enterpriseDto.getAddress().getAddressLine1())){
                errors.add("Address 1 is required");
            }

            if(!StringUtils.hasLength(enterpriseDto.getAddress().getCity())){
                errors.add("City is required");
            }

            if(!StringUtils.hasLength(enterpriseDto.getAddress().getCountry())){
                errors.add("Country is required");
            }
        }



        return errors;
    }
}
