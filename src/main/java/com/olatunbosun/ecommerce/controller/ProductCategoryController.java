package com.olatunbosun.ecommerce.controller;

import com.olatunbosun.ecommerce.exception.ApiResponse;
import com.olatunbosun.ecommerce.service.ProductCategoryServiceImpl;
import com.olatunbosun.ecommerce.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:06
 */



@RestController
@RequestMapping("/v1/product-category")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryServiceImpl productCategoryService;


    @GetMapping("")
    public ApiResponse getAllProductCategory() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public ApiResponse getProductById(@PathVariable Long id) {
        return productCategoryService.getProductCategoryById(id);
    }
}
