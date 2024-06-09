package com.olatunbosun.ecommerce.exception;

import com.olatunbosun.ecommerce.config.DiscordWebhookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author olulodeolatunbosun
 * @created 08/06/2024/06/2024 - 05:11
 */

@ControllerAdvice
public class GlobalExceptionHandler {



    // Handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//        ErrorResponse error = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                false,
//                List.of(""),
//                ex.getMessage(),
//                System.currentTimeMillis()
//        );

        ErrorResponse error = ErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .status(false)
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        logErrorDetails(request, ex);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .status(false)
                .message("An unexpected error occurred")
                .errors(List.of(ex.getMessage()))
                .timestamp(System.currentTimeMillis())
                .build();
        logErrorDetails(request, ex);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    // Handle validation errors (optional)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
     BindingResult bindingResult = ex.getBindingResult();

        // Collect field errors
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        // Build error messages list
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        logErrorDetails(request, ex);

        ErrorResponse error = ErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .status(false)
                .message(ex.getMessage())
                .errors(errors)
                .timestamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    // Utility method to log error details
    private void logErrorDetails(WebRequest request, Exception ex) {

        // Create the message
        String message = "Error occured here: \n" + request.getDescription(false) + "\n" + ex.getMessage();
        // Print the message and send it to Discord
        System.out.println(message);
        DiscordWebhookService.sendLog(message);
        // Log request details and exception information (optional)
        System.out.println("Request Description: " + request.getDescription(false));
        System.out.println("Exception Message: " + ex.getMessage());
        // Additional logging logic here...
    }
}
