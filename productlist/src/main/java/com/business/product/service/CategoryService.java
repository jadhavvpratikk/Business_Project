package com.business.product.service;

import com.business.product.dto.CategoryDTO;
import com.business.product.entity.Category;
import com.business.product.mapper.CategoryMapper;
import com.business.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    //get category by id
    //delete category
}
