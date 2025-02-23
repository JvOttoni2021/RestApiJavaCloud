package me.dio.rest.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiErrorResponse> handleNoSuchElementException(NoSuchElementException ex, HttpServletRequest request) {
        return createResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        return createResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(IllegalArgumentException ex, HttpServletRequest request) {
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error.", request);
    }

    private ResponseEntity<ApiErrorResponse> createResponse(HttpStatus responseStatus,
                                                            String message,
                                                            HttpServletRequest request) {
        var response = new ApiErrorResponse(responseStatus, message, request.getRequestURI());

        return ResponseEntity.status(responseStatus).body(response);
    }
}
