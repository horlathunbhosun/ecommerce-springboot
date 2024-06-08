package com.olatunbosun.ecommerce.exception;

import lombok.Data;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:12
 */

@Data
public class ErrorResponse {

    private int statusCode;
    private boolean status;
    private String message;
    private long timestamp;
    public ErrorResponse() {}
    public ErrorResponse(int statusCode,  boolean status,String message, long timestamp) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
