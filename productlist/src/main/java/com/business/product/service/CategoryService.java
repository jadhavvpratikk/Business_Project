package com.business.product.service;

import com.business.product.dto.CategoryDTO;
import com.business.product.entity.Category;
import com.business.product.mapper.CategoryMapper;
import com.business.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    //create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    //get all Categories
    public List<CategoryDTO> getAllCategories() {
       return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    //get category by id
    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }


    //delete category
    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category "+id+" has been deleted!";
    }
}
