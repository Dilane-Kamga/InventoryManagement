package com.kamtech.inventorymanagement.controllers.api;

import com.kamtech.inventorymanagement.dto.ItemDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/items")
public interface ItemApi {

    @PostMapping(value = APP_ROOT + "/items/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save an item", notes = "This method allows us to save or update an item ", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "item was created/updated successfully"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    ItemDto save(@RequestBody ItemDto itemDto);

    @GetMapping(value = APP_ROOT + "/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve an item by ID", notes = "This method allows us to retrieve an item by its ID ", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "item was found successfully"),
            @ApiResponse(code = 404, message = "item not found")
    })
    ItemDto findById(@PathVariable("itemId") Integer id);

    @GetMapping(value = APP_ROOT + "/items/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve an item by Code", notes = "This method allows us to retrieve an item by its Code ", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "item was found successfully"),
            @ApiResponse(code = 404, message = "item not found")
    })
    ItemDto findByCode(@PathVariable("itemCode") String code);

    @GetMapping(value = APP_ROOT + "/items/All", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve all items", notes = "This method allows us to retrieve all items", responseContainer = "List<ItemDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "items were found successfully")
    })
    List<ItemDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/items/delete/{itemId}")
    @ApiOperation(value = "Delete an item", notes = "This method allows us to delete an item by its ID ", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "item was delete successfully")
    })
    void delete(@PathVariable("itemId") Integer id);
}
