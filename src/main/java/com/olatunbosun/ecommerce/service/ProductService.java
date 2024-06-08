package com.olatunbosun.ecommerce.service;

import com.olatunbosun.ecommerce.exception.ApiResponse;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:04
 */
public interface ProductService {

    ApiResponse getAllProducts();

    ApiResponse getProductById(Long id);


}
