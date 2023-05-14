package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.SupplierOrderDto;
import com.kamtech.inventorymanagement.dto.SupplierOrderLineDto;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Item;
import com.kamtech.inventorymanagement.model.Supplier;
import com.kamtech.inventorymanagement.model.SupplierOrder;
import com.kamtech.inventorymanagement.model.SupplierOrderLine;
import com.kamtech.inventorymanagement.repository.ItemRepository;
import com.kamtech.inventorymanagement.repository.SupplierOrderLineRepository;
import com.kamtech.inventorymanagement.repository.SupplierOrderRepository;
import com.kamtech.inventorymanagement.repository.SupplierRepository;
import com.kamtech.inventorymanagement.services.SupplierOrderService;
import com.kamtech.inventorymanagement.validator.SupplierOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierOrderServiceImpl implements SupplierOrderService{

    private SupplierOrderRepository supplierOrderRepository;

    private SupplierRepository supplierRepository;

    private ItemRepository itemRepository;

    private SupplierOrderLineRepository supplierOrderLineRepository;

    public SupplierOrderServiceImpl(SupplierOrderRepository supplierOrderRepository, SupplierRepository supplierRepository, ItemRepository itemRepository, SupplierOrderLineRepository supplierOrderLineRepository) {
        this.supplierOrderRepository = supplierOrderRepository;
        this.supplierRepository = supplierRepository;
        this.itemRepository = itemRepository;
        this.supplierOrderLineRepository = supplierOrderLineRepository;
    }


    @Override
    public SupplierOrderDto save(SupplierOrderDto supplierOrderDto) {
        // the same as for CustomerOrderServiceImpl

        List<String> errors = SupplierOrderValidator.validate(supplierOrderDto);

        if(!errors.isEmpty()){
            log.warn("Supplier Order Validation Failed");
            throw new InvalidEntityException("Supplier Order Validation Failed", ErrorCodes.SUPPLIER_ORDER_NOT_VALID ,errors);
        }

        Optional<Supplier> supplier = supplierRepository.findById(supplierOrderDto.getSupplier().getId());
        if(supplier.isEmpty()){
            log.warn("Supplier with id {} not found", supplierOrderDto.getSupplier().getId());
            throw new InvalidEntityException("Supplier with id " + supplierOrderDto.getSupplier().getId() + " not found", ErrorCodes.SUPPLIER_NOT_FOUND);
        }

        List<String> itemErrors = new ArrayList<>();

        if (supplierOrderDto.getSupplierOrderLines() != null) {
            supplierOrderDto.getSupplierOrderLines().forEach(supplierOrderLineDto -> {
                if (supplierOrderLineDto.getItem() != null) {
                    Optional<Item> item = itemRepository.findById(supplierOrderLineDto.getItem().getId());
                    if (item.isEmpty()) {
                        itemErrors.add("Item with id " + supplierOrderLineDto.getItem().getId() + " not found");
                    }
                } else {
                    itemErrors.add("Item is null");
                }
            });
        }

        if(!itemErrors.isEmpty()){
            log.warn("Supplier Order Line Validation Failed");
            throw new InvalidEntityException("Supplier Order Line Validation Failed", ErrorCodes.SUPPLIER_ORDER_LINE_NOT_VALID ,itemErrors);
        }

        SupplierOrder supplierOrder = supplierOrderRepository.save(SupplierOrderDto.toEntity(supplierOrderDto));

        supplierOrderDto.getSupplierOrderLines().forEach(supplierOrderLineDto -> {
            SupplierOrderLine supplierOrderLine = SupplierOrderLineDto.toEntity(supplierOrderLineDto);
            supplierOrderLine.setSupplierOrder(supplierOrder);
            supplierOrderLineRepository.save(supplierOrderLine);
        });

        return SupplierOrderDto.fromEntity(supplierOrder);

    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        if (id == null) {
            log.warn("Supplier Order id is null");
            return null;
        }

        return supplierOrderRepository.findById(id)
                .map(SupplierOrderDto::fromEntity).
                orElseThrow(() -> new InvalidEntityException("Supplier Order with id " + id + " not found", ErrorCodes.SUPPLIER_ORDER_NOT_FOUND));
    }

    @Override
    public SupplierOrderDto findByCode(String orderNumber) {
        if (orderNumber == null) {
            log.warn("Supplier Order code is null");
            return null;
        }

        return supplierOrderRepository.findByCode(orderNumber)
                .map(SupplierOrderDto::fromEntity).
                orElseThrow(() -> new InvalidEntityException("Supplier Order with code " + orderNumber + " not found", ErrorCodes.SUPPLIER_ORDER_NOT_FOUND));
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderRepository.findAll()
                .stream()
                .map(SupplierOrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.warn("Supplier Order id is null");
            return;
        }

        supplierOrderRepository.deleteById(id);
    }
}
