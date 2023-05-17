package com.kamtech.inventorymanagement.controllers.api;

import com.kamtech.inventorymanagement.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a category", notes = "This method allows us to save or update a category ", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "category was created/updated successfully"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = APP_ROOT + "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a category by ID", notes = "This method allows us to retrieve a category by its ID ", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "category was found successfully"),
            @ApiResponse(code = 404, message = "category not found")
    })
    CategoryDto findById(@PathVariable("categoryId") Integer id);

    @GetMapping(value = APP_ROOT + "/categories/{categoryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a category by Code", notes = "This method allows us to retrieve a category by its Code ", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "category was found successfully"),
            @ApiResponse(code = 404, message = "category not found")
    })
    CategoryDto findByCode(@PathVariable("categoryCode") String code);

    @GetMapping(value = APP_ROOT + "/categories/All", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve all category", notes = "This method allows us to retrieve all categories", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "categories were found successfully")
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{CategoryId}")
    @ApiOperation(value = "Delete a Category", notes = "This method allows us to delete a Category by its ID ", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category was delete successfully")
    })
    void delete(@PathVariable("CategoryId") Integer id);
}
