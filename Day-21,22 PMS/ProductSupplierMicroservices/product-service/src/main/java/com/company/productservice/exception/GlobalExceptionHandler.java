package com.company.productservice.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ─── Product Exceptions ───────────────────────────────────────────────────

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFoundException(ProductNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, "Product Not Found", ex.getMessage());
    }

    @ExceptionHandler(DuplicateProductException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateProductException(DuplicateProductException ex) {
        return buildResponse(HttpStatus.CONFLICT, "Duplicate Product", ex.getMessage());
    }

    @ExceptionHandler(InvalidProductDataException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidProductDataException(InvalidProductDataException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Invalid Product Data", ex.getMessage());
    }

    // ─── Supplier Exceptions ──────────────────────────────────────────────────

    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleSupplierNotFoundException(SupplierNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, "Supplier Not Found", ex.getMessage());
    }

    @ExceptionHandler(InvalidSupplierIdException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidSupplierIdException(InvalidSupplierIdException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Invalid Supplier ID", ex.getMessage());
    }

    @ExceptionHandler(SupplierServiceDownException.class)
    public ResponseEntity<Map<String, Object>> handleSupplierServiceDownException(SupplierServiceDownException ex) {
        return buildResponse(HttpStatus.SERVICE_UNAVAILABLE, "Supplier Service Down", ex.getMessage());
    }

    // ─── Feign Exceptions ─────────────────────────────────────────────────────

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Map<String, Object>> handleFeignNotFoundException(FeignException.NotFound ex) {
        return buildResponse(HttpStatus.NOT_FOUND, "Supplier Not Found",
                "Supplier not found in supplier-service. Please verify the supplier ID.");
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Map<String, Object>> handleFeignException(FeignException ex) {
        return buildResponse(HttpStatus.SERVICE_UNAVAILABLE, "Supplier Service Down",
                "Unable to communicate with supplier-service. Please try again later.");
    }

    // ─── Validation Exceptions ────────────────────────────────────────────────

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Validation Failed");
        errorResponse.put("validationErrors", validationErrors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // ─── Database Exception ───────────────────────────────────────────────────

    @ExceptionHandler(org.springframework.dao.DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleDatabaseException(org.springframework.dao.DataAccessException ex) {
        return buildResponse(HttpStatus.SERVICE_UNAVAILABLE, "Database Connection Failure",
                "Unable to connect to the database. Please try again later.");
    }

    // ─── Generic Exception ────────────────────────────────────────────────────

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", ex.getMessage());
    }

    // ─── Helper ───────────────────────────────────────────────────────────────

    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String error, String message) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("status", status.value());
        errorResponse.put("error", error);
        errorResponse.put("message", message);
        return new ResponseEntity<>(errorResponse, status);
    }
}
