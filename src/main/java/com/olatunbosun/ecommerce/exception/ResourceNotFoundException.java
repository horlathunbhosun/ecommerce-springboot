package com.olatunbosun.ecommerce.exception;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:14
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
