package com.olatunbosun.ecommerce.controller;

import com.olatunbosun.ecommerce.exception.ApiResponse;
import com.olatunbosun.ecommerce.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:06
 */



@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    private final ProductServiceImpl productService;


    @GetMapping("")
    public ApiResponse getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ApiResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
