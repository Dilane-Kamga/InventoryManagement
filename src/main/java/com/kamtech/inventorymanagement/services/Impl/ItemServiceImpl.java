package com.kamtech.inventorymanagement.services.Impl;

import com.kamtech.inventorymanagement.dto.ItemDto;
import com.kamtech.inventorymanagement.exception.EntityNotFoundException;
import com.kamtech.inventorymanagement.exception.ErrorCodes;
import com.kamtech.inventorymanagement.exception.InvalidEntityException;
import com.kamtech.inventorymanagement.model.Item;
import com.kamtech.inventorymanagement.repository.ItemRepository;
import com.kamtech.inventorymanagement.services.ItemService;
import com.kamtech.inventorymanagement.validator.ItemValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    @Override
    public ItemDto save(ItemDto itemDto) {
        List<String> errors = ItemValidator.validate(itemDto);
        if(!errors.isEmpty()){
            log.error("Item is not valid {} : ", itemDto);
            throw new InvalidEntityException("The item is not valid", ErrorCodes.ITEM_NOT_VALID, errors);
        }

        return ItemDto.fromEntity(itemRepository.save(ItemDto.toEntity(itemDto)));
    }

    @Override
    public ItemDto findById(Integer id) {
        if(id == null){
            log.error("Item ID is null");
            return null;
        }

        Optional<Item> item = itemRepository.findById(id);

        return Optional.of(ItemDto.fromEntity(item.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "No item with ID = "+ id + "was found into the database", ErrorCodes.ITEM_NOT_FOUND
                ));

    }

    @Override
    public ItemDto findByCode(String code) {

        if (!StringUtils.hasLength(code)){
            log.error("Item code is null");
            return null;
        }

        Optional<Item> item = itemRepository.findByItemCode(code);

        return Optional.of(ItemDto.fromEntity(item.get())).orElseThrow(() ->
            new EntityNotFoundException(
                    "No item with code = " + code + "was found into the database", ErrorCodes.ITEM_NOT_FOUND
            ));
    }

    @Override
    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream()
                .map(ItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null)
            log.error("Item ID is null");

        itemRepository.deleteById(id);
    }
}
