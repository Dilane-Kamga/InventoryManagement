package com.kamtech.inventorymanagement.controllers;

import com.kamtech.inventorymanagement.controllers.api.ItemApi;
import com.kamtech.inventorymanagement.dto.ItemDto;
import com.kamtech.inventorymanagement.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController implements ItemApi {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        return itemService.save(itemDto);
    }

    @Override
    public ItemDto findById(Integer id) {
        return itemService.findById(id);
    }

    @Override
    public ItemDto findByCode(String code) {
        return itemService.findByCode(code);
    }

    @Override
    public List<ItemDto> findAll() {
        return itemService.findAll();
    }

    @Override
    public void delete(Integer id) {
        itemService.delete(id);
    }
}
