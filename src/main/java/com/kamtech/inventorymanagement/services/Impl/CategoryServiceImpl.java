package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.CategoryDto;

import com.kamtech.inventorymanagement.exception.EntityNotFoundException;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Category;

import com.kamtech.inventorymanagement.repository.CategoryRepository;
import com.kamtech.inventorymanagement.services.CategoryService;
import com.kamtech.inventorymanagement.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        List<String> errors = CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("Category is not valid {} : ", categoryDto);
            throw new InvalidEntityException("The Category is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("Item ID is null");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(id);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "No Category with ID = "+ id + "was found into the database", ErrorCodes.CATEGORY_NOT_FOUND
                ));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Category code is null");
            return null;
        }

        Optional<Category> category = categoryRepository.findCategoryByCode(code);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "No Category with code = " + code + "was found into the database", ErrorCodes.CATEGORY_NOT_FOUND
                ));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
            log.error("Category ID is null");

        categoryRepository.deleteById(id);
    }
}
