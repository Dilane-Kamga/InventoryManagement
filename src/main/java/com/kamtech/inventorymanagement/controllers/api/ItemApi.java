package com.kamtech.inventorymanagement.controllers.api;

import com.kamtech.inventorymanagement.dto.ItemDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

public interface ItemApi {

    @PostMapping(value = APP_ROOT + "/items/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDto save(@RequestBody ItemDto itemDto);

    @GetMapping(value = APP_ROOT + "/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDto findById(@PathVariable("itemId") Integer id);

    @GetMapping(value = APP_ROOT + "/items/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDto findByCode(@PathVariable("itemCode") String code);

    @GetMapping(value = APP_ROOT + "/items/All", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ItemDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/items/delete/{itemId}")
    void delete(@PathVariable("itemId") Integer id);
}
