package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.SalesDto;
import com.kamtech.inventorymanagement.dto.SalesLineDto;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Item;
import com.kamtech.inventorymanagement.model.Sales;
import com.kamtech.inventorymanagement.model.SalesLine;
import com.kamtech.inventorymanagement.repository.ItemRepository;
import com.kamtech.inventorymanagement.repository.SalesLineRepository;
import com.kamtech.inventorymanagement.repository.SalesRepository;
import com.kamtech.inventorymanagement.services.SalesService;
import com.kamtech.inventorymanagement.validator.SalesValidator;
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
public class SalesServiceImpl implements SalesService {

    private ItemRepository itemRepository;

    private SalesRepository salesRepository;

    private SalesLineRepository salesLineRepository;

    @Autowired
    public SalesServiceImpl (ItemRepository itemRepository, SalesRepository salesRepository, SalesLineRepository salesLineRepository){
        this.itemRepository = itemRepository;
        this.salesRepository = salesRepository;
        this.salesLineRepository = salesLineRepository;
    }

    @Override
    public SalesDto save(SalesDto salesDto) {
        List<String> errors = SalesValidator.validate(salesDto);

        if(!errors.isEmpty()){
            log.error("Sales is not valid");
            throw new InvalidEntityException("Sales is not valid ", ErrorCodes.SALES_NOT_VALID, errors);
        }

        List<String> itemErrors = new ArrayList<>();

        salesDto.getSalesLineDto().forEach(salesLineDto -> {
            Optional<Item> item = itemRepository.findById(salesLineDto.getItem().getId());
            if(item.isEmpty()){
                itemErrors.add("Item with id " + salesLineDto.getItem().getId() + " not found");
            }
        });

        if(!itemErrors.isEmpty()){
            log.error("Items not found");
            throw new InvalidEntityException("Items not found", ErrorCodes.ITEM_NOT_FOUND, itemErrors);
        }

        Sales sales = salesRepository.save(SalesDto.toEntity(salesDto));

        salesDto.getSalesLineDto().forEach(salesLineDto -> {
            SalesLine salesLine = SalesLineDto.toEntity(salesLineDto);
            salesLine.setSales(sales);
            salesLineRepository.save(salesLine);
        });

        return SalesDto.fromEntity(sales);
    }

    @Override
    public SalesDto findById(Integer id) {
        if (id == null) {
            log.error("Sales id is null");
            return null;
        }

        return salesRepository.findById(id)
                .map(SalesDto::fromEntity)
                .orElseThrow(() ->
                        new InvalidEntityException("No sales found with id = " + id, ErrorCodes.SALES_NOT_FOUND));
    }

    @Override
    public SalesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Sales code is null");
            return null;
        }

        return salesRepository.findByCode(code)
                .map(SalesDto::fromEntity)
                .orElseThrow(() ->
                        new InvalidEntityException("No sales found with code = " + code, ErrorCodes.SALES_NOT_FOUND));
    }

    @Override
    public List<SalesDto> findAll() {
        return salesRepository.findAll().stream()
                .map(SalesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Sales id is null");
            return;
        }

        salesRepository.deleteById(id);
    }
}
