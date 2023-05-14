package com.kamtech.inventorymanagement.services;

import com.kamtech.inventorymanagement.dto.ItemDto;

import java.util.List;


public interface ItemService {

    ItemDto save(ItemDto itemDto);

    ItemDto findById(Integer id);

    ItemDto findByCode(String code);

    List<ItemDto> findAll();

    void delete(Integer id);
}
