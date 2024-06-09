package com.olatunbosun.ecommerce.exception;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:19
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ApiResponse {
    private String message;
    private boolean status;
    @JsonProperty("status_code")
    private int statusCode;
    private Object data;


}
