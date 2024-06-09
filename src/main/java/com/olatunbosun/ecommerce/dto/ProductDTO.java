package com.olatunbosun.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:05
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;
    @JsonProperty("image_url")
    private String imageUrl;
    private boolean active;
    @JsonProperty("units_in_stock")
    private int unitsInStock;
    @JsonProperty("category")
    private ProductCategoryDTO categoryDTO;
    @JsonProperty("date_created")
    private Date dateCreated;
    @JsonProperty("last_updated")
    private Date lastUpdated;
}
