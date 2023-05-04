package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDto rolesDto){

        List<String> errors = new ArrayList<>();

        if(rolesDto == null){
            errors.add("Role is required");
            return errors;
        }

        if (!StringUtils.hasLength(rolesDto.getRoleName())){
            errors.add("Role name is required");
        }

        if (rolesDto.getUser() == null){
            errors.add("User is required");
        }

        return errors;
    }
}
