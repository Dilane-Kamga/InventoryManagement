package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.CustomerOrderDto;
import com.kamtech.inventorymanagement.dto.CustomerOrderLineDto;
import com.kamtech.inventorymanagement.exception.EntityNotFoundException;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Customer;
import com.kamtech.inventorymanagement.model.CustomerOrder;
import com.kamtech.inventorymanagement.model.CustomerOrderLine;
import com.kamtech.inventorymanagement.model.Item;
import com.kamtech.inventorymanagement.repository.CustomerOrderLineRepository;
import com.kamtech.inventorymanagement.repository.CustomerOrderRepository;
import com.kamtech.inventorymanagement.repository.CustomerRepository;
import com.kamtech.inventorymanagement.repository.ItemRepository;
import com.kamtech.inventorymanagement.services.CustomerOrderService;
import com.kamtech.inventorymanagement.validator.CustomerOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService{

    private CustomerOrderRepository customerOrderRepository;

    private CustomerRepository customerRepository;

    private ItemRepository itemRepository;

    private CustomerOrderLineRepository customerOrderLineRepository;

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository, ItemRepository itemRepository, CustomerOrderLineRepository customerOrderLineRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.customerOrderLineRepository = customerOrderLineRepository;
    }

    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {

        List<String> errors = CustomerOrderValidator.validate(customerOrderDto);

        if(!errors.isEmpty()){
            log.warn("Customer Order Validation Failed");
            throw new InvalidEntityException("Customer Order Validation Failed", ErrorCodes.CUSTOMER_ORDER_NOT_VALID ,errors);
        }

        Optional<Customer> customer = customerRepository.findById(customerOrderDto.getCustomer().getId());
        if(customer.isEmpty()){
            log.warn("Customer with id {} not found", customerOrderDto.getCustomer().getId());
            throw new InvalidEntityException("Customer with id " + customerOrderDto.getCustomer().getId() + " not found", ErrorCodes.CUSTOMER_NOT_FOUND);
        }

        List<String> itemErrors = new ArrayList<>();

        if (customerOrderDto.getCustomerOrderLines() != null) {
            customerOrderDto.getCustomerOrderLines().forEach(customerOrderLineDto -> {
                if (customerOrderLineDto.getItem() != null) {
                    Optional<Item> item = itemRepository.findById(customerOrderLineDto.getItem().getId());
                    if (item.isEmpty()) {
                        itemErrors.add("Item with id " + customerOrderLineDto.getItem().getId() + " not found");
                    } else {
                        itemErrors.add("Unable to save an item with ID NULL");
                    }
            }
                });
        }

        if (!itemErrors.isEmpty()){
            log.warn("Item Not Found");
            throw new InvalidEntityException("Item Not Found", ErrorCodes.ITEM_NOT_FOUND, itemErrors);
        }

        CustomerOrder customerOrder = customerOrderRepository.save(CustomerOrderDto.toEntity(customerOrderDto));

        customerOrderDto.getCustomerOrderLines().forEach(customerOrderLineDto -> {
            CustomerOrderLine customerOrderLine = CustomerOrderLineDto.toEntity(customerOrderLineDto);
            customerOrderLine.setCustomerOrder(customerOrder);
            customerOrderLineRepository.save(customerOrderLine);
        });

        return CustomerOrderDto.fromEntity(customerOrder);
    }

    @Override
    public CustomerOrderDto findById(Integer id) {
        if (id == null){
            log.warn("Customer Order ID is NULL");
            return null;
        }

        return customerOrderRepository.findById(id)
                .map(CustomerOrderDto::fromEntity)
                .orElseThrow(()
                        -> new EntityNotFoundException("Customer Order with ID " + id + " not found", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND
                ));
    }

    @Override
    public CustomerOrderDto findByCode(String code) {

        if (!StringUtils.hasLength(code)){
            log.warn("Customer Order Code is NULL");
            return null;
        }

        return customerOrderRepository.findByCode(code)
                .map(CustomerOrderDto::fromEntity)
                .orElseThrow(()
                        -> new EntityNotFoundException("Customer Order with Code " + code + " not found", ErrorCodes.CUSTOMER_ORDER_NOT_FOUND
                ));
    }

    @Override
    public List<CustomerOrderDto> findAll() {
        return customerOrderRepository.findAll()
                .stream()
                .map(CustomerOrderDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.warn("Customer Order ID is NULL");
            return;
        }

        customerOrderRepository.deleteById(id);
    }
}
