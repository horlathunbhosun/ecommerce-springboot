package com.olatunbosun.ecommerce.exception;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:18
 */
public class MethodArgumentNotValidException extends RuntimeException{
    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
