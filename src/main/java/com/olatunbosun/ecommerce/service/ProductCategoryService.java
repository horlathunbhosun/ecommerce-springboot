package com.olatunbosun.ecommerce.service;

import com.olatunbosun.ecommerce.exception.ApiResponse;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:06
 */
public interface ProductCategoryService {

    ApiResponse getAllProductCategories();

    ApiResponse getProductCategoryById(Long id);

}
