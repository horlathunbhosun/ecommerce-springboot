package com.olatunbosun.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {
    private Long id;
    @JsonProperty("category_name")
    private String categoryName;
}
