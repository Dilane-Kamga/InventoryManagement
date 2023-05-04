package com.kamtech.inventorymanagement.validator;

import com.kamtech.inventorymanagement.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto userDto) {

        List<String> errors = new ArrayList<>();

        if(userDto == null ) {
            errors.add("User is required");
            return errors;
        }

        if(!StringUtils.hasLength(userDto.getFirstName())){
            errors.add("First name is required");
        }

        if(!StringUtils.hasLength(userDto.getLastName())){
            errors.add("Last name is required");
        }

        if(!StringUtils.hasLength(userDto.getPassword())){
            errors.add("Password is required");
        }

        if(userDto.getAddress() == null){
            errors.add("Address is required");
        } else {
            if(!StringUtils.hasLength(userDto.getAddress().getAddressLine1())){
                errors.add("Address 1 is required");
            }

            if(!StringUtils.hasLength(userDto.getAddress().getCity())){
                errors.add("City is required");
            }

            if(!StringUtils.hasLength(userDto.getAddress().getCountry())){
                errors.add("Country is required");
            }
        }

        if(!StringUtils.hasLength(userDto.getEmail())){
            errors.add("Email is required");
        }

        if(!StringUtils.hasLength(userDto.getFirstName())){
            errors.add("First name is required");
        }

        if(userDto.getBirthDate() == null){
            errors.add("Birth Date is required");
        }




        return errors;
    }
}
