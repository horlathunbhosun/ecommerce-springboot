package com.olatunbosun.ecommerce.dao;

import com.olatunbosun.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 04:54
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
