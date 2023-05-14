package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.CustomerDto;
import com.kamtech.inventorymanagement.exception.EntityNotFoundException;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Customer;
import com.kamtech.inventorymanagement.repository.CustomerRepository;
import com.kamtech.inventorymanagement.services.CustomerService;
import com.kamtech.inventorymanagement.validator.CustomerValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    @Override
    public CustomerDto save(CustomerDto customerDto) {
        List<String> errors = CustomerValidator.validate(customerDto);

        if(!errors.isEmpty()){
            log.error("Customer is not valid {} : ", customerDto);
            throw new InvalidEntityException("The Customer is not valid", ErrorCodes.ITEM_NOT_VALID, errors);
        }

        return CustomerDto.fromEntity(customerRepository.save(CustomerDto.toEntity(customerDto)));
    }

    @Override
    public CustomerDto findById(Integer id) {
        if(id == null){
            log.error("Customer ID is null");
            return null;
        }

        Optional<Customer> customer = customerRepository.findById(id);

        return Optional.of(CustomerDto.fromEntity(customer.get())).orElseThrow(() ->
                new EntityNotFoundException("No Customer with ID " +id+ "was found into the database", ErrorCodes.ITEM_NOT_FOUND
                ));
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
            log.error("Customer ID is null");

        customerRepository.deleteById(id);
    }
}
