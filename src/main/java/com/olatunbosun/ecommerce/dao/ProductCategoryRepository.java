package com.olatunbosun.ecommerce.dao;

import com.olatunbosun.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 04:55
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
