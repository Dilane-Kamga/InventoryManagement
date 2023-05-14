package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.SupplierDto;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Supplier;
import com.kamtech.inventorymanagement.repository.SupplierRepository;
import com.kamtech.inventorymanagement.services.SupplierService;
import com.kamtech.inventorymanagement.validator.SupplierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        List<String> errors = SupplierValidator.validate(supplierDto);

        if(!errors.isEmpty()){
            log.error("Supplier is not valid {} : ", supplierDto);
            throw new InvalidEntityException("The Supplier is not valid", ErrorCodes.SUPPLIER_NOT_VALID, errors);
        }

        return SupplierDto.fromEntity(supplierRepository.save(SupplierDto.toEntity(supplierDto)));
    }

    @Override
    public SupplierDto findById(Integer id) {
        if (id == null) {
            log.error("Supplier ID is null");
            return null;
        }

        Optional<Supplier> supplier = supplierRepository.findById(id);

        return Optional.of(SupplierDto.fromEntity(supplier.get())).orElseThrow(() ->
                new InvalidEntityException("No Supplier with ID " + id + "was found into the database", ErrorCodes.SUPPLIER_NOT_FOUND
                ));
    }

    @Override
    public List<SupplierDto> findAll() {
        return supplierRepository.findAll().stream()
                .map(SupplierDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Supplier ID is null");
            return;
        }
        supplierRepository.deleteById(id);
    }
}
