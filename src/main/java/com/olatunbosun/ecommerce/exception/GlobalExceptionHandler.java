package com.olatunbosun.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:11
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                false,
                ex.getMessage(),
                System.currentTimeMillis()
        );

        logErrorDetails(request, ex);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                false,
                "An unexpected error occurred",
                System.currentTimeMillis()
        );
        logErrorDetails(request, ex);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    // Handle validation errors (optional)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
//        String errorMessage = ex.getBindingResult().getAllErrors().stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.joining(", "));
//
//        ErrorResponse error = new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                errorMessage,
//                System.currentTimeMillis()
//        );
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }


    // Utility method to log error details
    private void logErrorDetails(WebRequest request, Exception ex) {
        // Log request details and exception information (optional)
        System.out.println("Request Description: " + request.getDescription(false));
        System.out.println("Exception Message: " + ex.getMessage());
        // Additional logging logic here...
    }
}
