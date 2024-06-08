package com.olatunbosun.ecommerce.service;

import com.olatunbosun.ecommerce.dao.ProductRepository;
import com.olatunbosun.ecommerce.entity.Product;
import com.olatunbosun.ecommerce.exception.ApiResponse;
import com.olatunbosun.ecommerce.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:04
 */

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private  ProductRepository productRepository;
    @Override
    public ApiResponse getAllProducts() {
     ApiResponse response    =    new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatus(true);
        response.setMessage("All products retrieved successfully");
        response.setData(productRepository.findAll());
        return response;
    }

    @Override
    public ApiResponse getProductById(Long id)  {
      //get product by id and throw exception if not found
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product not found");
        }
        ApiResponse response    =    new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatus(true);
        response.setMessage("Product retrieved successfully");
        response.setData(product.get());
        return response;
    }
}
