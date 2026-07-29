package com.company.productservice.exception;

public class InvalidSupplierIdException extends RuntimeException {

    public InvalidSupplierIdException(String message) {
        super(message);
    }

    public InvalidSupplierIdException(Long supplierId) {
        super("Invalid supplier ID provided: " + supplierId);
    }
}
