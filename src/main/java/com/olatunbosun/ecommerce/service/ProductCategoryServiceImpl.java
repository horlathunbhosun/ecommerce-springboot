package com.olatunbosun.ecommerce.service;

import com.olatunbosun.ecommerce.dao.ProductCategoryRepository;
import com.olatunbosun.ecommerce.dto.ProductCategoryDTO;
import com.olatunbosun.ecommerce.entity.ProductCategory;
import com.olatunbosun.ecommerce.exception.ApiResponse;
import com.olatunbosun.ecommerce.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:06
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    @Override
    public ApiResponse getAllProductCategories() {
        //get all product categories and return as a list of productCategoryDTO
        Iterable<ProductCategory> productCategories = productCategoryRepository.findAll();

        List<ProductCategoryDTO> productCategoryDTOList = new ArrayList<>();
        for (ProductCategory category : productCategories) {
            ProductCategoryDTO categoryDTO = mapProductCategoryToDTO(category);
            productCategoryDTOList.add(categoryDTO);
        }
        ApiResponse response = new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatus(true);
        response.setMessage("All product categories retrieved successfully");
        response.setData(productCategoryDTOList);
        return response;
    }

    @Override
    public ApiResponse getProductCategoryById(Long id) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
        if(productCategory.isEmpty()){
            throw new ResourceNotFoundException("Product category not found  with " + id , this.getClass());
        }

        ProductCategoryDTO categoryDTO = mapProductCategoryToDTO(productCategory.get());
        ApiResponse response = new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatus(true);
        response.setMessage("All product categories retrieved successfully");
        response.setData(categoryDTO);
        return response;
    }

    private ProductCategoryDTO mapProductCategoryToDTO(ProductCategory category) {
        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO;
    }
}
