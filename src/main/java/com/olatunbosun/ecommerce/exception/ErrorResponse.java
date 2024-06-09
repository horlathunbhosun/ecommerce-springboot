package com.olatunbosun.ecommerce.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:12
 */

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private boolean status;
    private List<String> errors;

    private String message;
    private long timestamp;

}
