package com.kamtech.inventorymanagement.services.Impl;


import com.kamtech.inventorymanagement.dto.EnterpriseDto;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Enterprise;
import com.kamtech.inventorymanagement.repository.EnterpriseRepository;
import com.kamtech.inventorymanagement.services.EnterpriseService;
import com.kamtech.inventorymanagement.validator.EnterpriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnterpriseServiceImpl implements EnterpriseService {

    private EnterpriseRepository enterpriseRepository;

    @Autowired
    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository){
        this.enterpriseRepository = enterpriseRepository;
    }


    @Override
    public EnterpriseDto save(EnterpriseDto enterpriseDto) {
        List<String> errors = EnterpriseValidator.validate(enterpriseDto);
        if(!errors.isEmpty()){
            log.error("Enterprise is not valid {} : ", enterpriseDto);
            throw new InvalidEntityException("The enterprise is not valid", ErrorCodes.ENTERPRISE_NOT_VALID, errors);
        }
        return EnterpriseDto.fromEntity(enterpriseRepository.save(EnterpriseDto.toEntity(enterpriseDto)));
    }

    @Override
    public EnterpriseDto findById(Integer id) {
        if (id == null){
            log.error("Enterprise ID is null");
            return null;
        }

        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);

        return Optional.of(EnterpriseDto.fromEntity(enterprise.get())).orElseThrow(() ->
                new InvalidEntityException(
                        "No enterprise with ID = "+ id + "was found into the database", ErrorCodes.ENTERPRISE_NOT_FOUND
                ));
    }

    @Override
    public List<EnterpriseDto> findAll() {
        return enterpriseRepository.findAll().stream()
                .map(EnterpriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Enterprise ID is null");
            return;
        }
        enterpriseRepository.deleteById(id);
    }
}
