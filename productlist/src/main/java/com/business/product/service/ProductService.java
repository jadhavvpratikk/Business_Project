package com.business.product.service;

import com.business.product.dto.ProductDTO;
import com.business.product.entity.Category;
import com.business.product.entity.Product;
import com.business.product.mapper.ProductMapper;
import com.business.product.repository.CategoryRepository;
import com.business.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    //getProducts
    //createProduct
    public ProductDTO createProduct(ProductDTO productDTO){
        /**
         * id, name, description, price, categoryId
         * **/
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found!"));
        //Dto -> entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        //entity -> DTO
        return ProductMapper.toProductDTO(product);
    }

    //get All Products
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toProductDTO)
                .toList();
    }

    //get product By Id
    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    //update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        //first we will check from product dto having same category id as present in category entity
        //second we will also check that category is same category name inside that database
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);


    }

    //delete product
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product "+id+" has been deleted";
    }





}
