package com.olatunbosun.ecommerce.service;

import com.olatunbosun.ecommerce.dao.ProductRepository;
import com.olatunbosun.ecommerce.dto.ProductCategoryDTO;
import com.olatunbosun.ecommerce.dto.ProductDTO;
import com.olatunbosun.ecommerce.entity.Product;
import com.olatunbosun.ecommerce.entity.ProductCategory;
import com.olatunbosun.ecommerce.exception.ApiResponse;
import com.olatunbosun.ecommerce.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:04
 */


@Service
public class ProductServiceImpl implements ProductService{

    private final   ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ApiResponse getAllProducts() {
        //get all products and return as a list of productDTO
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            ProductDTO productDTO = mapProductToDTO(product);
            productDTOList.add(productDTO);
        }

     ApiResponse response    =    new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatus(true);
        response.setMessage("All products retrieved successfully");
        response.setData(productDTOList);
        return response;
    }

    @Override
    public ApiResponse getProductById(Long id)  {
      //get product by id and throw exception if not found
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product not found  with " + id, this.getClass() );
        }
        ApiResponse response   =    new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatus(true);
        response.setMessage("Product retrieved successfully");
        response.setData(mapProductToDTO(product.get()));
        return response;
    }



    private ProductDTO mapProductToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();

        // Set properties of the DTO from the corresponding properties of the entity
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setUnitsInStock(product.getUnitsInStock());
        productDTO.setActive(product.isActive());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setLastUpdated(product.getLastUpdated());
        productDTO.setDateCreated(product.getDateCreated());
        productDTO.setCategoryDTO(mapProductCategoryToDTO(product.getCategory()));
        return productDTO;
    }


    private ProductCategoryDTO mapProductCategoryToDTO(ProductCategory category) {
        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO;
    }

}
