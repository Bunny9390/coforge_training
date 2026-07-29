package com.company.productservice.exception;

public class SupplierServiceDownException extends RuntimeException {

    public SupplierServiceDownException(String message) {
        super(message);
    }

    public SupplierServiceDownException() {
        super("Supplier service is currently unavailable. Please try again later.");
    }
}
