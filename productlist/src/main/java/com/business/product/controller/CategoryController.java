package com.business.product.controller;

import com.business.product.dto.CategoryDTO;
import com.business.product.entity.Category;
import com.business.product.exception.CategoryAlreadyExistsException;
import com.business.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "Category REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operations for Category REST API"
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    //create Category
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @Operation(
            summary = "Create category",
            description = "REST API to create category."
    )
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){

            CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

        //return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //get Categories
    @Operation(
            summary = "Fetch all categories",
            description = "REST API to fetch all categories along with their products."
    )
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    //get category by id
    @Operation(
            summary = "Fetch category by category Id",
            description = "REST API to fetch category by category Id."
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }


    //delete category
    @Operation(
            summary = "Delete category by category Id",
            description = "REST API to delete category by category Id."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
    }

}
