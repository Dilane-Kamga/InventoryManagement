package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.UserDto;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.User;
import com.kamtech.inventorymanagement.repository.UserRepository;
import com.kamtech.inventorymanagement.services.UserService;
import com.kamtech.inventorymanagement.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDto save(UserDto userDto) {
        List<String> errors = UserValidator.validate(userDto);

        if (!errors.isEmpty()){
            log.error("User is not valid {}", userDto);
            throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_VALID, errors);
        }

        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(userDto)));

    }

    @Override
    public UserDto findById(Integer id) {
        if (id == null){
            log.error("User ID is null");
            return null;
        }

        Optional<User> user = userRepository.findById(id);

        return Optional.of(UserDto.fromEntity(user.get())).orElseThrow(() ->
                new InvalidEntityException(
                        "No user with ID = "+ id + "was found into the database", ErrorCodes.USER_NOT_FOUND
                ));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("User ID is null");
            return;
        }
        userRepository.deleteById(id);
    }
}
